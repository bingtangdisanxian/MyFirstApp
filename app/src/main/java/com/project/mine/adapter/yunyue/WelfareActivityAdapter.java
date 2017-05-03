package com.project.mine.adapter.yunyue;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * @author 钟教授
 * @time 2017/4/27  11:31
 * @desc ${TODD}
 */

public class WelfareActivityAdapter extends PagerAdapter{


    private ArrayList<ImageView> mImageViews;

    public WelfareActivityAdapter(ArrayList<ImageView> imageViews) {
        this.mImageViews = imageViews;
    }

    @Override
    public int getCount() {
        return mImageViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = mImageViews.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
