package com.project.mine.ui.yunyue.zhongyuan.android;

import android.content.Intent;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.project.mine.R;
import com.project.mine.base.activity.BaseActivity;

/**
 * @author 钟教授
 * @time 2017/4/27  16:39
 * @desc ${TODD}
 */

public class BigAndroidActivity extends BaseActivity {

    public static final String WEB_URL = "web_URL";
    public static final String DESC = "desc";
    private WebView mWebView;
    private String mWebURL;
    private Toolbar mToolbar;
    private String mDesc;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_big_android;
    }

    @Override
    protected void initWindowParams() {
        super.initWindowParams();
        requestImmersion();
    }

    @Override
    protected void initView() {
        mWebView = (WebView) findViewById(R.id.android_web);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);//设置标题不可见
        actionBar.setDisplayHomeAsUpEnabled(true);//左上角图标可以被点击
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);//引导图标
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mWebURL = intent.getStringExtra(WEB_URL);
        mDesc = intent.getStringExtra(DESC);

        mWebView.getSettings().setJavaScriptEnabled(true);
        // 避免重定向跳到系统的浏览器中,需要做处理
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.loadUrl(mWebURL);
        mToolbar.setTitle(mDesc);

    }

}
