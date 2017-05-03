package com.project.mine.ui.yunyue.zhongyuan.welfare;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.WelfareActivityAdapter;
import com.project.mine.base.activity.BaseActivity;
import com.project.mine.bean.yunyue.music.WelfareBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoView;

/**
 * @author 钟教授
 * @time 2017/4/27  11:01
 * @desc ${TODD}
 */

public class WelfareActivity extends BaseActivity {

    public static final String INDEX = "index";
    public static final String PIC_URL = "pic_url";
    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tv_index)
    TextView mTvIndex;
    @BindView(R.id.tv_total)
    TextView mTvTotal;

    private int mPosition;
    private List<WelfareBean.ResultsBean> mPicUrls;
    private ArrayList<ImageView> mImageViews;
    private WelfareActivityAdapter mActivityAdapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_welfare;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mPosition = intent.getIntExtra(INDEX, 0);
        mPicUrls = (List<WelfareBean.ResultsBean>) intent.getSerializableExtra(PIC_URL);
        mImageViews = new ArrayList<>();
        for (int i = 0; i < mPicUrls.size(); i++) {
            // ImageView imageView = new ImageView(this);
            PhotoView photoView = new PhotoView(getApplicationContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            photoView.setLayoutParams(params);
            Glide.with(WelfareActivity.this).load(mPicUrls.get(i).getUrl())
                    .placeholder(R.drawable.load_err)
                    .into(photoView);
            mImageViews.add(photoView);
        }
    }

    @Override
    protected void initWindowParams() {
        super.initWindowParams();
        requestImmersion();
    }

    @Override
    protected void initEvent() {
        mActivityAdapter = new WelfareActivityAdapter(mImageViews);
        mVp.setAdapter(mActivityAdapter);

        mTvTotal.setText(mPicUrls.size() + "");
        mTvIndex.setText((mPosition + 1) + "/");
        mVp.setCurrentItem(mPosition);


        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTvIndex.setText((position + 1) + "/");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
