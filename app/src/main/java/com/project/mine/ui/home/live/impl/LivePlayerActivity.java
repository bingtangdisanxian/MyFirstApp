package com.project.mine.ui.home.live.impl;

import android.content.pm.ActivityInfo;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.project.mine.R;
import com.project.mine.base.activity.BaseLiveActivity;
import com.project.mine.bean.home.module.ListBean;
import com.project.mine.listener.MyOnHorControllListener;
import com.project.mine.listener.MyOnVerticalControllerListener;
import com.project.mine.ui.home.live.interfaze.LivePlayerView;
import com.project.mine.wedgit.media.HorMediaControllerView;
import com.project.mine.wedgit.media.VerticalMediaControllerView;

import butterknife.BindView;

/**
 * Created by chenqi on 2017/4/24.
 * 描述:
 */
public class LivePlayerActivity extends BaseLiveActivity implements LivePlayerView,
        View.OnTouchListener, VerticalMediaControllerView.OnFullScreenListener {

    @BindView(R.id.statusbar)
    View mStatusBar;
    @BindView(R.id.surfaceView)
    SurfaceView mSurfaceView;
    @BindView(R.id.bgImg)
    ImageView mBgImg;
    @BindView(R.id.LoadingView)
    LinearLayout mLoadingView;
    @BindView(R.id.verticalControll)
    VerticalMediaControllerView mVerticalController;
    @BindView(R.id.horizontalControll)
    HorMediaControllerView mHorizontalController;

    private int mPortWidth;
    private int mPortHeight;
    private LivePlayerHolder playerHolder;
    private ListBean mListBean;
    private boolean isVertical = true;
    private int mCodec;

    @Override
    protected void initWindowParams() {
        requestImmersion();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.act_commonliveplayer;
    }

    @Override
    protected void initParams() {
        initPlayer();
        initVerController();
        initHorController();
    }

    private void initPlayer() {
        mSurfaceView.setOnTouchListener(this);
        mListBean = (ListBean) getIntent().getSerializableExtra("listBean");
        mCodec = getIntent().getIntExtra("mediaCodec", 0);
    }

    private void initVerController() {
        mVerticalController = (VerticalMediaControllerView) findViewById(R.id.verticalControll);
        mVerticalController.setOnVerticalControllListener(new MyOnVerticalControllerListener(this, playerHolder));
        mVerticalController.setOnFullScreenListener(this);
    }

    private void initHorController() {
        mHorizontalController = (HorMediaControllerView) findViewById(R.id.horizontalControll);
        mHorizontalController.setOnHorControllerListener(new MyOnHorControllListener(this, playerHolder));
    }

    @Override
    public void initialize() {
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void requestPermissionSucceed() {
        initLiveView();
    }

    private void initLiveView() {
        if (mListBean != null) {
            Glide.with(this)
                    .load(mListBean.thumb)
                    .fitCenter()
                    .into(mBgImg);
            mVerticalController.setData(mListBean);
            playerHolder = new LivePlayerHolder(this, mSurfaceView, mCodec, mListBean.stream);
            playerHolder.startPlayer();
        }
    }

    @Override
    protected void toPrepare() {
        if (playerHolder != null)
            playerHolder.prepare();
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
        if (requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            isVertical = true;
            mVerticalController.onCreate();
            mHorizontalController.onDestroy();

        } else {
            isVertical = false;
            mHorizontalController.onCreate();
            mVerticalController.onDestroy();
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mVerticalController.onTouchEvent(isVertical, event);
        mHorizontalController.onTouchEvent(isVertical, event);
        return false;
    }

    @Override
    public void onVerticalClickFullScreen() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        int heightPixels = metrics.heightPixels;
        int widthPixels = metrics.widthPixels;
        ViewGroup.LayoutParams params = mSurfaceView.getLayoutParams();

        int height = params.height;
        int width = params.width;

        //status bar
        ViewGroup.LayoutParams mStatusBarParams = mStatusBar.getLayoutParams();
        mStatusBarParams.height = 0;
        getWindow().getDecorView().setSystemUiVisibility(View.INVISIBLE);
        mPortWidth = width;
        mPortHeight = height;
        params.width = widthPixels;
        params.height = heightPixels;
    }

    @Override
    public void onBackPressed() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            ViewGroup.LayoutParams params = mSurfaceView.getLayoutParams();
            params.width = mPortWidth;
            params.height = mPortHeight;

            ViewGroup.LayoutParams mStatusBarParams = mStatusBar.getLayoutParams();
            mStatusBarParams.height = (int) (getResources().getDimension(R.dimen.status_bar_height) + 0.5f);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            return;
        }
        if (playerHolder != null)
            playerHolder.release();
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (playerHolder != null) {
            playerHolder.release();
            playerHolder = null;
        }
    }

    @Override
    public void onReConnecting() {
        showToastTips("正在重连...");
    }

    @Override
    public void onConnectSuccess() {
        mLoadingView.setVisibility(View.GONE);
    }

    @Override
    public void onPlayerStart() {
        mBgImg.animate().alpha(0).setDuration(1000).start();
    }
}
