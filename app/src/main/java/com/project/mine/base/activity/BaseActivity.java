package com.project.mine.base.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:普通Activity的基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected View mView; //布局对应的View
    protected boolean isImmersion; //是否是沉浸式
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initWindowParams(); // 1. 初始化窗口参数

        initWindowUI();  // 2. 初始化窗口布局
    }

    protected void initWindowParams() {
    }

    private void initWindowUI() {

        // 设置布局
        mView = getLayoutInflater().inflate(getLayoutResId(), null);
        setContentView(mView);

        // 绑定控件
        mUnbinder = ButterKnife.bind(this);

        initView();

        initData();

        initEvent();
    }

    protected abstract int getLayoutResId();

    protected void initView() {
    }

    protected void initData() {
    }

    protected void initEvent() {
    }

    //请求沉浸式,5.0以上才能实现
    protected void requestImmersion() {
        isImmersion = true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!isImmersion)
            return;
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    //往Activity中添加fragment
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(containerViewId,fragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
