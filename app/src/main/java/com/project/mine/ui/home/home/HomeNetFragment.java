package com.project.mine.ui.home.home;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.live.HidePageRcyAdapter;
import com.project.mine.adapter.live.TabLayoutPagerAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.home.tablayout.LiveCategory;
import com.project.mine.listener.CommonAnimListener;
import com.project.mine.listener.TransAnimListener;
import com.project.mine.wedgit.tablayout.DachshundIndicator;
import com.project.mine.wedgit.tablayout.DachshundTabLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:主界面的内容展示
 */
public class HomeNetFragment extends BaseNetFragment<HomeContract.Presenter> implements HomeContract.View {

    @BindView(R.id.vp_home)
    ViewPager mVpHome;
    @BindView(R.id.frame_change_title)
    FrameLayout mFrameChangeTitle;
    @BindView(R.id.tab_layout)
    DachshundTabLayout mTabLayout;
    @BindView(R.id.tv_change_tip)
    TextView mTvChangeTip;
    @BindView(R.id.i_btn_arrow)
    ImageButton mIBtnArrow;

    private boolean mIsAnimFinish = true;//代表动画是否播放完成
    private boolean mIsDown = true;//代表箭头的方向

    //箭头动画
    private ValueAnimator mValueAnimUp;
    private ValueAnimator mValueAnimDown;

    //覆盖页动画
    private TranslateAnimation mTransAnimShow;
    private TranslateAnimation mTransAnimHide;

    private RecyclerView mRecyclerView;//覆盖页面数据填充

    public static HomeNetFragment newInstance() {
        HomeNetFragment homeFragment = new HomeNetFragment();
        new HomePresenter(homeFragment);
        return homeFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        initChangeTitle();
        initAnimator();
        initEvent();
    }

    private void initChangeTitle() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.banner_change_title, null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rcl_tab_layout_content);
        mFrameChangeTitle.addView(view);
    }

    private void initAnimator() {

        mValueAnimUp = new ValueAnimator();
        mValueAnimUp.setFloatValues(0, 90);
        mValueAnimDown = ValueAnimator.ofFloat(90, 0);

        MyAnimUpdateListener updateListener = new MyAnimUpdateListener();
        mValueAnimUp.addUpdateListener(updateListener);
        mValueAnimDown.addUpdateListener(updateListener);

        AnimListener animListener = new AnimListener();
        mValueAnimDown.addListener(animListener);
        mValueAnimUp.addListener(animListener);

        mValueAnimUp.setDuration(500);
        mValueAnimDown.setDuration(500);

        //制作补间动画
        mTransAnimShow = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, -1,
                TranslateAnimation.RELATIVE_TO_SELF, 0);

        mTransAnimHide = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, 0,
                TranslateAnimation.RELATIVE_TO_SELF, -1);

        TransAnimListener transAnimListener = new MyTransAnimListener();
        mTransAnimHide.setAnimationListener(transAnimListener);

        mTransAnimShow.setDuration(500);
        mTransAnimHide.setDuration(500);
    }

    //动画专场
    private class MyAnimUpdateListener implements ValueAnimator.AnimatorUpdateListener {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            float animatedValue = (float) animation.getAnimatedValue();
            mIBtnArrow.setRotation(animatedValue);
        }
    }

    private class AnimListener extends CommonAnimListener {
        @Override
        public void onAnimationStart(Animator animation) {
            //一播放动画,就方向对调
            mIsAnimFinish = false;
            mIsDown = !mIsDown;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            //动画播放完了,再让其为true,才可以继续点击播放动画
            mIsAnimFinish = true;
        }
    }

    private class MyTransAnimListener extends TransAnimListener {

        @Override
        public void onAnimationEnd(Animation animation) {
            //隐藏一些View (白屏) (切换栏目)
            mFrameChangeTitle.setVisibility(View.GONE);
            mTvChangeTip.setVisibility(View.GONE);
        }
    }

    @Override
    protected void initialize() {
        mPresenter.start();
    }

    @Override
    protected void requestPermissionSucceed() {
        mSubscription = mPresenter.requestData(mParams);
    }

    @Override
    protected void resetRequest() {
        mSubscription = mPresenter.requestData(mParams);
    }

    @Override
    public void showTabLayout(List<LiveCategory> list) {
        setTabLayout(list);//设置顶部标题导航
        setImageButton(list);//设置tabLayout的侧面按钮
    }

    private void setTabLayout(List<LiveCategory> list) {
        mTabLayout.setVisibility(View.VISIBLE);//成功获取数据时才显示tabLayout
        mVpHome.setAdapter(new TabLayoutPagerAdapter(getActivity().getSupportFragmentManager(), list));
        mTabLayout.setupWithViewPager(mVpHome);
        mTabLayout.setAnimatedIndicator(new DachshundIndicator(mTabLayout));
    }

    //网络请求成功时才会调用
    private void setImageButton(List<LiveCategory> list) {
        initEvent();
        setRecyclerData(list);
    }

    private void initEvent() {
        mIBtnArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsAnimFinish) {
                    return;//动画未播放完,不走后面的逻辑了
                }
                if (mIsDown) {
                    showTitleChange();
                } else {
                    hideTitleChange();
                }
            }
        });
    }

    private void showTitleChange() {
        //代表先前的箭头是向下时,播放向上的动画,并且展示切换栏目,然后还要展示白屏
        mValueAnimUp.start();
        mTvChangeTip.setVisibility(View.VISIBLE);
        mFrameChangeTitle.setVisibility(View.VISIBLE);
        mFrameChangeTitle.startAnimation(mTransAnimShow);
        //更换图标
        mIBtnArrow.setImageResource(R.drawable.ic_show_game_list);
    }

    private void hideTitleChange() {
        //代表先前的箭头是向上时,播放向下的动画,并且隐藏切换栏目,然后还要隐藏白屏
        mValueAnimDown.start();
        mTvChangeTip.setVisibility(View.GONE);
        //在动画结束后再隐藏掉
        mFrameChangeTitle.startAnimation(mTransAnimHide);
        //更换图标
        mIBtnArrow.setImageResource(R.drawable.ic_hide_game_list);
    }

    private void setRecyclerData(final List<LiveCategory> list) {

        for (int i = 0; i < list.size(); i++) {
            if (i == 9) {
                list.get(i).setItemType(LiveCategory.TEXT);
                list.get(i).setSpanSize(LiveCategory.TEXT_SPAN_SIZE);
            } else {
                list.get(i).setItemType(LiveCategory.IMG_TEXT);
                list.get(i).setSpanSize(LiveCategory.IMG_TEXT_SPAN_SIZE);
            }
        }
        HidePageRcyAdapter adapter = new HidePageRcyAdapter(list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return list.get(position).getSpanSize();
            }
        });

        mRecyclerView.setAdapter(adapter);
    }
}
