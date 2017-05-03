package com.project.mine.ui.yunyue.zhongyuan.android;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.AndroidAdapter;
import com.project.mine.adapter.yunyue.BigAndroidAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.music.BigAndroidBean;
import com.project.mine.ui.yunyue.zhongyuan.welfare.GridSpacingItemDecoration;

import java.util.List;

import butterknife.BindView;


/**
 * @author 钟教授
 * @time 2017/4/26  11:50
 * @desc ${TODD}
 */

public class BigAndroidFragment extends BaseNetFragment<BigAndroidContract.Presenter>
        implements BigAndroidContract.View {


    @BindView(R.id.android_rlv)
    RecyclerView mAndroidRlv;
    private BigAndroidAdapter mAdapter;
    private RequestParamsBean mRequestParamsBean;

    public static BigAndroidFragment newInstance() {
        BigAndroidFragment bigAndroidFragment = new BigAndroidFragment();
        new BigAndroidPresenter(bigAndroidFragment);
        return bigAndroidFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_bigandroid;
    }

    @Override
    protected void initData() {
        mRequestParamsBean = new RequestParamsBean();
        mRequestParamsBean.dataCount = 1;
        mRequestParamsBean.requestPages = 10;
    }

    @Override
    protected void initialize() {
        mPresenter.start();
    }

    @Override
    protected void requestPermissionSucceed() {
        mSubscription = mPresenter.requestData(mRequestParamsBean);
    }

    @Override
    protected void resetRequest() {
        mSubscription = mPresenter.requestData(mRequestParamsBean);
    }

    @Override
    public void showItem(final BigAndroidBean bigAndroidBean) {
        //mAdapter = new BigAndroidAdapter(bigAndroidBean);
        //mAndroidRlv.setLayoutManager(new LinearLayoutManager(mContext));
        //mAndroidRlv.setAdapter(mAdapter);

        AndroidAdapter androidAdapter = new AndroidAdapter(R.layout.item_big_android, bigAndroidBean.getResults());
        mAndroidRlv.setLayoutManager(new LinearLayoutManager(mContext));
        mAndroidRlv.addItemDecoration(new GridSpacingItemDecoration(1, 10, true));
        mAndroidRlv.setAdapter(androidAdapter);

        androidAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), BigAndroidActivity.class);
                List<BigAndroidBean.ResultsBean> results = bigAndroidBean.getResults();
                intent.putExtra(BigAndroidActivity.WEB_URL, results.get(position).getUrl());
                intent.putExtra(BigAndroidActivity.DESC, results.get(position).getDesc());
                startActivity(intent);
            }
        });
    }
}
