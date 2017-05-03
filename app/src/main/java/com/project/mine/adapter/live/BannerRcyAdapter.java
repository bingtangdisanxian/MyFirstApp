package com.project.mine.adapter.live;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenqi on 2017/3/6.
 * 描述:轮播图适配器(图片加载是用的Glide,需要导入依赖)
 */
public class BannerRcyAdapter extends PagerAdapter {
    private List<String> mList;

    public BannerRcyAdapter(ArrayList<String> picUrls) {
        mList = picUrls;
    }

    @Override
    public int getCount() {
        return mList != null ? mList.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(container.getContext());
        Glide.with(container.getContext())
                .load(mList.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
