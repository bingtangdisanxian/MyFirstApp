package com.project.mine.adapter.yunyue;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.project.mine.ui.yunyue.shuaishuai.wenxue.WenXueFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gnices on 2017/4/26.
 */

public class BookAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;
    private List<String> mName;

    public BookAdapter(FragmentManager fm, List<String> tiletName) {
        super(fm);
        mList = new ArrayList<>();
        mList.add(WenXueFragment.newInstance("文学"));
        mList.add(WenXueFragment.newInstance("文化"));
        mList.add(WenXueFragment.newInstance("生活"));
        mName = tiletName;

    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mName.get(position);
    }
}
