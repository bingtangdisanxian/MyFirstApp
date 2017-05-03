package com.project.mine.adapter.live;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.project.mine.bean.home.tablayout.LiveCategory;
import com.project.mine.ui.home.tablayout.RecommendNetFragment;

import java.util.List;


/**
 * Created by chenqi on 2017/3/8.
 * 描述:顶部切换界面的适配器
 */
public class TabLayoutPagerAdapter extends FragmentStatePagerAdapter {

    private List<LiveCategory> mLiveCategoryList;

    public TabLayoutPagerAdapter(FragmentManager fm, List<LiveCategory> list) {
        super(fm);
        mLiveCategoryList = list;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return RecommendNetFragment.newInstance();
        }

        LiveCategory liveCategory = mLiveCategoryList.get(position);
        String url = "json/categories/" + liveCategory.slug + "/list.json";
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putString("tag", liveCategory.name);
        if (liveCategory.slug.equals("love")) {
            return RecommendNetFragment.newInstance();
        }
        return RecommendNetFragment.newInstance();
    }

    @Override
    public int getCount() {
        return mLiveCategoryList != null ? mLiveCategoryList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mLiveCategoryList.get(position).name;
    }
}
