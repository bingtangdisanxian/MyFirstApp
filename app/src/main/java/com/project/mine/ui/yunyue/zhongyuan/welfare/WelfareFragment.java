package com.project.mine.ui.yunyue.zhongyuan.welfare;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.mine.R;
import com.project.mine.adapter.yunyue.WelfareAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.music.WelfareBean;
import com.project.mine.listener.WelfareClickListener;
import com.project.mine.util.UIUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;

/**
 * @author 钟教授
 * @time 2017/4/26  11:49
 * @desc ${TODD}
 */

public class WelfareFragment extends BaseNetFragment<WelfareContract.Presenter>
        implements WelfareContract.View {

    @BindView(R.id.rlv_welfare)
    RecyclerView mRlvWelfare;
    private WelfareAdapter mWelfareAdapter;
    private RequestParamsBean mParamsBean;
    private List<WelfareBean.ResultsBean> mResults;

    public static WelfareFragment newInstance() {
        WelfareFragment welfareFragment = new WelfareFragment();
        new WelfarePresenter(welfareFragment);
        return welfareFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_welfare;
    }

    @Override
    protected void initData() {
        mParamsBean = new RequestParamsBean();
        mParamsBean.dataCount = 2;
        mParamsBean.requestPages = 40;
    }

    @Override
    protected void initialize() {
        mPresenter.start();
    }

    @Override
    protected void requestPermissionSucceed() {
        mSubscription = mPresenter.requestData(mParamsBean);
    }


    @Override
    protected void resetRequest() {
        mSubscription = mPresenter.requestData(mParamsBean);
    }

    @Override
    public void showPic(WelfareBean welfareBean) {
        mResults = welfareBean.getResults();
        mWelfareAdapter = new WelfareAdapter(mResults);
        mRlvWelfare.setAdapter(mWelfareAdapter);
        mRlvWelfare.addItemDecoration(new GridSpacingItemDecoration(2, 10, true));
        mRlvWelfare.setLayoutManager(new GridLayoutManager(UIUtils.getContext(), 2));
        mWelfareAdapter.setWelfareClickListener(new WelfareClickListener() {
            @Override
            public void OnClickListener(int position) {
                Intent intent = new Intent(getActivity(), WelfareActivity.class);
                intent.putExtra(WelfareActivity.INDEX, position);
                intent.putExtra(WelfareActivity.PIC_URL, (Serializable) mResults);
                startActivity(intent);
            }
        });
    }


}
