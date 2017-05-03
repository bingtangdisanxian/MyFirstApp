package com.project.mine.wedgit.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.project.mine.R;
import com.project.mine.adapter.live.BannerRcyAdapter;

import java.util.ArrayList;

/**
 * Created by chenqi on 2017/3/6.
 * 描述:自定义轮播图
 */
public class Banner extends RelativeLayout {
    private ArrayList<String> mTitles;
    private ArrayList<String> mPictures;
    private int mListSize;
    private ViewPager mViewPagerBanner;
    private TextView mTvBanner;
    private LinearLayout mLlDot;
    private static final int DELAY_TIME = 2000;

    @SuppressLint("handlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currentItem = mViewPagerBanner.getCurrentItem();
            mViewPagerBanner.setCurrentItem(currentItem + 1);
            mHandler.sendEmptyMessageDelayed(0, DELAY_TIME);
        }
    };

    @SuppressWarnings("unchecked")
    public void setDatas(ArrayList<String>... values) {
        if (values.length == 1) {
            setData(values[0]);//只展示图片
        }
        if (values.length == 2) {
            setData(values[0], values[1]);//展示图片和文字
        }
    }

    public Banner(Context context) {
        this(context, null);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_layout, this, true);
        mViewPagerBanner = (ViewPager) view.findViewById(R.id.viewPager_banner);
        mTvBanner = (TextView) view.findViewById(R.id.tv_banner);
        mLlDot = (LinearLayout) view.findViewById(R.id.ll_dot);
    }

    private void setData(ArrayList<String> pictures) {
        mPictures = pictures;
        mListSize = pictures.size();
        //没有文字时-->将文本控件隐藏并置为空
        mTvBanner.setVisibility(View.GONE);
        mTvBanner = null;

        initUnLimitImage();
        BannerRcyAdapter bannerRcyAdapter = new BannerRcyAdapter(mPictures);
        mViewPagerBanner.setAdapter(bannerRcyAdapter);
        //初始化小点
        initDot();

        //设置翻页监听
        BannerOnPagerChangeListener changeListener = new BannerOnPagerChangeListener();
        mViewPagerBanner.addOnPageChangeListener(changeListener);

        //修改第一次初始化展示的标题和小点
        changeDot(0);
        mViewPagerBanner.setCurrentItem(1);
        start();
    }

    private void setData(ArrayList<String> titles, ArrayList<String> pictures) {
        mTitles = titles;
        mPictures = pictures;
        mListSize = titles.size();

        initUnLimitImage();
        BannerRcyAdapter bannerRcyAdapter = new BannerRcyAdapter(mPictures);
        mViewPagerBanner.setAdapter(bannerRcyAdapter);
        //初始化小点
        initDot();

        //设置翻页监听
        BannerOnPagerChangeListener changeListener = new BannerOnPagerChangeListener();
        mViewPagerBanner.addOnPageChangeListener(changeListener);

        //修改第一次初始化展示的标题和小点
        mTvBanner.setText(mTitles.get(0));
        changeDot(0);
        mViewPagerBanner.setCurrentItem(1);
        start();
    }

    //修改集合中数据,让集合首尾各加一张图片
    private void initUnLimitImage() {
        ArrayList<String> backup = new ArrayList<>();
        backup.addAll(mPictures);
        mPictures.clear();
        mPictures.add(backup.get(backup.size() - 1));
        mPictures.addAll(backup);
        mPictures.add(backup.get(0));
    }

    private void initDot() {
        mLlDot.removeAllViews();//将小点个数置零
        for (int i = 0; i < mListSize; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(R.drawable.dot_normal_bg);
            //通过LayoutParams来设置代码动态添加时的布局效果//-2就代表wrap_content
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 10, 0);
            mLlDot.addView(imageView, layoutParams);
        }
    }

    private class BannerOnPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            position = getRealPosition(position);
            if (mTvBanner != null) mTvBanner.setText(mTitles.get(position));
            changeDot(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            //如果是特殊的位置,就要偷偷切换
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                int position = mViewPagerBanner.getCurrentItem();
                if (position == 0) {
                    mViewPagerBanner.setCurrentItem(mPictures.size() - 2, false);
                }
                if (position == mPictures.size() - 1) {
                    mViewPagerBanner.setCurrentItem(1, false);
                }
            }
        }
    }

    //获得真正的位置
    private int getRealPosition(int position) {
        int realPosition;
        if (position == 0) {
            realPosition = mListSize - 1;
        } else if (position == mPictures.size() - 1) {
            realPosition = 0;
        } else {
            realPosition = position - 1;
        }
        return realPosition;
    }

    private void changeDot(int position) {
        for (int i = 0; i < mLlDot.getChildCount(); i++) {
            ImageView child = (ImageView) mLlDot.getChildAt(i);
            if (i == position) {
                child.setImageResource(R.drawable.dot_select_bg);
            } else {
                child.setImageResource(R.drawable.dot_normal_bg);
            }
        }
    }

    //只能在分发或拦截中处理,因为父容器是获取不到响应事件的(子view要消费)
    //而且在dispatchTouchEvent中处理只能返回super在onInterceptTouchEvent处理只能返回super/false
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int eventAction = ev.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                stop();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                //当触摸点移除轮播图外时
            case MotionEvent.ACTION_CANCEL:
                start();
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void start() {
        stop();//防止多次start造成混乱
        mHandler.sendEmptyMessageDelayed(0, DELAY_TIME);
    }

    public void stop() {
        mHandler.removeCallbacksAndMessages(null);
    }
}
