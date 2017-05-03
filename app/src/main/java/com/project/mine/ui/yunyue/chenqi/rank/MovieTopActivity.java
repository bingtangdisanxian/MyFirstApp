package com.project.mine.ui.yunyue.chenqi.rank;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.project.mine.R;
import com.project.mine.base.activity.BaseActivity;

import butterknife.BindView;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class MovieTopActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_movie_top;
    }

    @Override
    protected void initView() {
        requestImmersion();
        setToolbar();
        addFragment(R.id.fl_activity_content,MovieTopFragment.newInstance());
    }

    private void setToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("豆瓣电影Top榜");
        actionBar.setDisplayHomeAsUpEnabled(true);//左上角图标可以被点击
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);//引导图标
    }
}
