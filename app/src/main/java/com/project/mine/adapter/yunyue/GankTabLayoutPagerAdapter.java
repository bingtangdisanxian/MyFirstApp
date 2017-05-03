package com.project.mine.adapter.yunyue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.project.mine.ui.yunyue.zhongyuan.Customized.CustomizedFragment;
import com.project.mine.ui.yunyue.zhongyuan.android.BigAndroidFragment;
import com.project.mine.ui.yunyue.zhongyuan.recommend.DayRecommendedFragment;
import com.project.mine.ui.yunyue.zhongyuan.welfare.WelfareFragment;

import java.util.ArrayList;

/**
 * @author 钟教授
 * @time 2017/4/26  9:56
 * @desc ${TODD}
 */

public class GankTabLayoutPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> mList;
    private ArrayList<Fragment> mFragment = new ArrayList<>();

    public GankTabLayoutPagerAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        mList = list;
        mFragment.add(DayRecommendedFragment.newInstance());
        mFragment.add(WelfareFragment.newInstance());
        mFragment.add(CustomizedFragment.newInstance());
        mFragment.add(BigAndroidFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position);
    }
}
