package com.project.mine.ui.home.tablayout;

import android.view.View;
import android.widget.ListView;

import com.project.mine.R;
import com.project.mine.adapter.live.RecommendListAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.home.banner.BannerBean;
import com.project.mine.bean.home.module.RoomBean;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.util.UIUtils;
import com.project.mine.wedgit.banner.Banner;
import com.project.mine.wedgit.refresh.MyPullRefreshFrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by chenqi on 2017/4/13.
 * 描述:
 */
public class RecommendNetFragment extends BaseNetFragment<RecommendContract.Presenter>
        implements RecommendContract.View {

    @BindView(R.id.lv_recommend)
    ListView mLvRecommend;

    @BindView(R.id.refresh_view)
    MyPullRefreshFrameLayout mRefreshView;
    private Banner mBanner;
    private RecommendListAdapter mAdapter;

    public static RecommendNetFragment newInstance() {
        RecommendNetFragment recommendFragment = new RecommendNetFragment();
        new RecommendPresenter(recommendFragment);
        return recommendFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initData() {
        mParams = new RequestParamsBean();
        mParams.mLayout = mRefreshView;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void requestPermissionSucceed() {
        mPresenter.requestBannerData();
        mSubscription = mPresenter.requestData(mParams);
        setPullRefresh();
    }

    @Override
    protected void resetRequest() {
        mPresenter.requestBannerData();
        mSubscription = mPresenter.requestData(mParams);
    }

    private void setPullRefresh() {
        mRefreshView.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                mPresenter.requestData(mParams);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                //第二个参数可限制刷新的类型
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mLvRecommend, header);
            }
        });
    }

    @Override
    public void showListModule(List<RoomBean> roomBeenList) {
        if (mAdapter == null){
            mAdapter = new RecommendListAdapter(mContext,
                    R.layout.recycler_item_recommend, roomBeenList);
            mLvRecommend.addHeaderView(mBanner);
            mLvRecommend.setAdapter(mAdapter);
        }else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showBanner(List<BannerBean> bannerBeenList) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (BannerBean bannerBean : bannerBeenList) {
            list1.add(bannerBean.thumb);
            list2.add(bannerBean.title);
        }
        mBanner = new Banner(UIUtils.getContext());
        mBanner.setDatas(list2, list1);
    }
}
