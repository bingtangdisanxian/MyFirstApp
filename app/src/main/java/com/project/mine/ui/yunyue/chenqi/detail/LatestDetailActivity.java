package com.project.mine.ui.yunyue.chenqi.detail;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.mine.R;
import com.project.mine.base.activity.BaseActivity;
import com.project.mine.bean.yunyue.movie.SubjectsBean;

import butterknife.BindView;

public class LatestDetailActivity extends BaseActivity {

    @BindView(R.id.header_image)
    ImageView mHeaderImage;              // 主题插图
    @BindView(R.id.tv_headline)
    TextView mTvHeadline;                // 文章大标题
    @BindView(R.id.tv_copyright)
    TextView mTvCopyright;               // 版权信息
    @BindView(R.id.toolbar)
    Toolbar mToolbar;                          // ToolBar控件
    @BindView(R.id.load_progress_bar)
    ProgressBar mLoadProgressBar;              // 进度条
    @BindView(R.id.wv_news_detail_container)
    WebView mWebView;             // webView容器
//    @BindView(R.id.floatingActionButton_main)
//    FloatingDraftButton mFloatingActionButtonMain;
    public static final String SUBJECT_BEAN = "subject_bean";

    @Override
    protected void initWindowParams() {
        requestImmersion();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_common_detail;
    }

    @Override
    protected void initView() {
        initData();
    }

    protected void initData() {

        SubjectsBean subjectsBean = (SubjectsBean) getIntent().getSerializableExtra(SUBJECT_BEAN);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(subjectsBean.title);
        actionBar.setDisplayHomeAsUpEnabled(true);//左上角图标可以被点击
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);//引导图标
        Glide.with(this).load(subjectsBean.images.large).crossFade().into(mHeaderImage);

        mWebView.setVisibility(View.VISIBLE);
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 避免重定向跳到系统的浏览器中,需要做处理
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(subjectsBean.alt);
    }
}
