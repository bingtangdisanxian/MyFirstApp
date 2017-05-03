package com.project.mine.ui.yunyue.zhongyuan.Customized;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.CustomizedAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.music.CustomizedBean;
import com.project.mine.listener.ITitleChangeListener;
import com.project.mine.ui.yunyue.zhongyuan.android.BigAndroidActivity;
import com.project.mine.ui.yunyue.zhongyuan.welfare.GridSpacingItemDecoration;
import com.project.mine.wedgit.pop.SelectedTypePop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author 钟教授
 * @time 2017/4/26  11:50
 * @desc ${TODD}
 */

public class CustomizedFragment extends BaseNetFragment<CustomizedConteact.Presenter>
        implements CustomizedConteact.View {


    @BindView(R.id.customized)
    RecyclerView mCustomized;
    @BindView(R.id.ll_customized)
    LinearLayout mLlCustomized;
    @BindView(R.id.ll_head)
    LinearLayout mLlHead;
    @BindView(R.id.iv)
    ImageView mIv;
    @BindView(R.id.ll_change_but)
    LinearLayout mLlChangeBut;
    @BindView(R.id.head_title)
    TextView mHeadTitle;


    private RequestParamsBean mParamsBean;
    private CustomizedAdapter mCustomizedAdapter;
    private SelectedTypePop mChooseAreaPop;
    private boolean isFirst = true;


    public static CustomizedFragment newInstance() {
        CustomizedFragment customizedFragment = new CustomizedFragment();
        new CustomizedPresenter(customizedFragment);
        return customizedFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_customized;
    }

    @Override
    protected void initData() {

        mParamsBean = new RequestParamsBean();
        mParamsBean.dataCount = 20;
        mParamsBean.requestPages = 1;
        mParamsBean.type = "all";

    }

    @Override
    protected void initialize() {
        mPresenter.start();
        //  Log.v("aaaaaa", "========");
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
    public void showResult(final CustomizedBean bean) {
        //Log.v("aaaaaaa", "==============");
        mCustomizedAdapter = new CustomizedAdapter(R.layout.item_big_android, bean.getResults());
        if (isFirst) {
            mCustomized.addItemDecoration(new GridSpacingItemDecoration(1, 10, true));
            isFirst = false;
        }
        mCustomized.setLayoutManager(new LinearLayoutManager(mContext));
        mCustomized.setAdapter(mCustomizedAdapter);
        mCustomizedAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), BigAndroidActivity.class);
                List<CustomizedBean.ResultsBean> results = bean.getResults();
                intent.putExtra(BigAndroidActivity.WEB_URL, results.get(position).getUrl());
                intent.putExtra(BigAndroidActivity.DESC, results.get(position).getDesc());
                startActivity(intent);
            }
        });
        setHeadView();
    }

    private void setHeadView() {
        mChooseAreaPop = new SelectedTypePop(getContext());
        mLlChangeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出一个窗口
                mChooseAreaPop.onShow(mLlChangeBut);
            }
        });

        mChooseAreaPop.setITitleChangeListener(new ITitleChangeListener() {
            @Override
            public void onChangListener(ArrayList<String> title, int position) {
                mHeadTitle.setText(title.get(position));
                if (title.get(position).equals("全部")) {
                    mParamsBean.type = "all";
                } else {
                    mParamsBean.type = title.get(position);
                }
                mSubscription = mPresenter.requestData(mParamsBean);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mView = null;
    }
}
