package com.project.mine.ui.yunyue.base;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.project.mine.R;
import com.project.mine.adapter.yunyue.MyFragmentPagerAdapter;
import com.project.mine.base.mvp.BaseFragment;
import com.project.mine.listener.MyOnPageChangeListener;
import com.project.mine.ui.yunyue.chenqi.movie.MovieFragment;
import com.project.mine.ui.yunyue.shuaishuai.book.BookFragment;
import com.project.mine.ui.yunyue.zhongyuan.GankFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by chenqi on 2017/4/11.
 * 描述:
 */
public class YunYueNetFragment extends BaseFragment  {

    @BindView(R.id.vp_content)
    ViewPager mVpContent;
    @BindView(R.id.iv_title_gank)
    ImageView mIvTitleGank;
    @BindView(R.id.iv_title_one)
    ImageView mIvTitleOne;
    @BindView(R.id.iv_title_dou)
    ImageView mIvTitleDou;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_chat;
    }

    public static YunYueNetFragment newInstance() {
        return new YunYueNetFragment();
    }


    @Override
    protected void initDatas(AppCompatActivity mActivity) {
        mActivity.setSupportActionBar(mToolbar);
        setNavigationView(mActivity);
        initViewPager();
    }

    private void setNavigationView(AppCompatActivity mActivity) {
        ActionBar actionBar = mActivity.getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);//设置标题不可见
        actionBar.setDisplayHomeAsUpEnabled(true);//左上角图标可以被点击
        actionBar.setHomeAsUpIndicator(R.drawable.titlebar_menu);//引导图标
    }

    private void initViewPager() {
        ArrayList<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(GankFragment.newInstance());
        mFragmentList.add(MovieFragment.newInstance());
        mFragmentList.add(BookFragment.newInstance());
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getActivity().getSupportFragmentManager(), mFragmentList);
        mVpContent.setAdapter(adapter);
        // 设置ViewPager最大缓存的页面个数(cpu消耗少)
        mVpContent.setOffscreenPageLimit(2);
        mVpContent.setCurrentItem(0);//设置展示第一页
        mIvTitleGank.setSelected(true);//设置第一项默认被选中
        mVpContent.addOnPageChangeListener(new MyOnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mIvTitleGank.setSelected(true);
                        mIvTitleOne.setSelected(false);
                        mIvTitleDou.setSelected(false);
                        break;
                    case 1:
                        mIvTitleOne.setSelected(true);
                        mIvTitleGank.setSelected(false);
                        mIvTitleDou.setSelected(false);
                        break;
                    case 2:
                        mIvTitleDou.setSelected(true);
                        mIvTitleOne.setSelected(false);
                        mIvTitleGank.setSelected(false);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.iv_title_gank, R.id.iv_title_one, R.id.iv_title_dou})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title_gank:// 干货栏
                if (mVpContent.getCurrentItem() != 0) {//不然cpu会有损耗
                    mIvTitleGank.setSelected(true);
                    mIvTitleOne.setSelected(false);
                    mIvTitleDou.setSelected(false);
                    mVpContent.setCurrentItem(0);
                }
                break;
            case R.id.iv_title_one:// 电影栏
                if (mVpContent.getCurrentItem() != 1) {
                    mIvTitleOne.setSelected(true);
                    mIvTitleGank.setSelected(false);
                    mIvTitleDou.setSelected(false);
                    mVpContent.setCurrentItem(1);
                }
                break;
            case R.id.iv_title_dou:// 书籍栏
                if (mVpContent.getCurrentItem() != 2) {
                    mIvTitleDou.setSelected(true);
                    mIvTitleOne.setSelected(false);
                    mIvTitleGank.setSelected(false);
                    mVpContent.setCurrentItem(2);
                }
                break;
        }
    }
}
