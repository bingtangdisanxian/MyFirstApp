package com.project.mine.ui.yunyue.zhongyuan;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.project.mine.R;
import com.project.mine.adapter.yunyue.GankTabLayoutPagerAdapter;
import com.project.mine.base.mvp.BaseFragment;
import com.project.mine.wedgit.tablayout.DachshundIndicator;
import com.project.mine.wedgit.tablayout.DachshundTabLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by chenqi on 2017/4/25.
 * 描述:
 */
public class GankFragment extends BaseFragment {


    @BindView(R.id.tab_layout)
    DachshundTabLayout mTabLayout;
    @BindView(R.id.gank_vp)
    ViewPager mGankVp;


    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_gank;
    }

    public static GankFragment newInstance() {
        return new GankFragment();
    }

    @Override
    protected void initDatas(AppCompatActivity activity) {

        ArrayList<String> list=new ArrayList<>();
        list.add("每日推荐");
        list.add("福利");
        list.add("干货定制");
        list.add("大安卓");
        mGankVp.setAdapter(new GankTabLayoutPagerAdapter(getActivity().getSupportFragmentManager(), list));
        mTabLayout.setupWithViewPager(mGankVp);
        mTabLayout.setAnimatedIndicator(new DachshundIndicator(mTabLayout));
    }

}
