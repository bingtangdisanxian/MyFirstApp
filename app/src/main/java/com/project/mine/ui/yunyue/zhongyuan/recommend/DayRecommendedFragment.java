package com.project.mine.ui.yunyue.zhongyuan.recommend;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.project.mine.R;
import com.project.mine.adapter.yunyue.MovieAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.movie.SubjectsBean;
import com.project.mine.constant.ConstantsImageUrl;
import com.project.mine.util.UIUtils;
import com.project.mine.wedgit.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author 钟教授
 * @time 2017/4/26  10:07
 * @desc ${TODD}
 */

public class DayRecommendedFragment extends BaseNetFragment<DayRecommendedContract.Presenter>
        implements DayRecommendedContract.View {


    @BindView(R.id.every_vp)
    FrameLayout mEveryVp;
    @BindView(R.id.recycler)
    RecyclerView mRecycler;
    private RequestParamsBean mParamsBean;
    private Banner mBanner;


    public static DayRecommendedFragment newInstance() {
        DayRecommendedFragment recommendFragment = new DayRecommendedFragment();
        new DayRecommendedPresenter(recommendFragment);
        return recommendFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_dayrecommend;
    }

    @Override
    protected void initData() {
        mParamsBean = new RequestParamsBean();
       // new RequestParamsBean();
    }

    @Override
    protected void initialize() {
        mPresenter.start();
    }

    @Override
    protected void requestPermissionSucceed() {
        mSubscription = mPresenter.requestData(mParamsBean);
        mPresenter.requestContentData(mParamsBean);
    }

    @Override
    protected void resetRequest() {
        mSubscription = mPresenter.requestData(mParamsBean);
    }

    @Override
    public void showBanner() {
        ArrayList<String> list = new ArrayList<>();
        //        for (EveryDayBean.ResultBeanXXXXXXXXXXXXXXX.FocusBean.ResultBeanXXX bannerBean : bannerBeans) {
        //            list.add(bannerBean.getRandpic());
        //        }
        list.add(ConstantsImageUrl.BANNER_1);
        list.add(ConstantsImageUrl.BANNER_2);
        list.add(ConstantsImageUrl.BANNER_3);
        list.add(ConstantsImageUrl.BANNER_4);
        list.add(ConstantsImageUrl.BANNER_5);
        mBanner = new Banner(UIUtils.getContext());
        mBanner.setDatas(list);
        mEveryVp.addView(mBanner);
    }

    @Override
    public void showResult(List<SubjectsBean> subjectsBeanList) {
        MovieAdapter movieAdapter = new MovieAdapter(R.layout.item_fragment_movie, subjectsBeanList);
        mRecycler.setLayoutManager(new LinearLayoutManager(mContext));
        mRecycler.setAdapter(movieAdapter);
    }

}
