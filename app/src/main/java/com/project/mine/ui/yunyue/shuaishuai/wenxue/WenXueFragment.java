package com.project.mine.ui.yunyue.shuaishuai.wenxue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.BookWenXueAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.book.BookDataBean;
import com.project.mine.ui.yunyue.shuaishuai.detail.BookDetailActivity;

import butterknife.BindView;

import static com.project.mine.ui.yunyue.shuaishuai.detail.BookDetailActivity.BOOKBEAN;
import static com.project.mine.ui.yunyue.shuaishuai.detail.BookDetailActivity.POSITION;

/**
 * Created by Gnices on 2017/4/26.
 * 文学界面
 */

public class WenXueFragment extends BaseNetFragment<WenXueContract.Presenter>
        implements WenXueContract.View {

    @BindView(R.id.rcl_wen_xue)
    RecyclerView mRclWenXue;

    private static final String TAG = "tag";

    public static WenXueFragment newInstance(String tag) {
        WenXueFragment wenXueFragment = new WenXueFragment();
        Bundle args = new Bundle();
        args.putString(TAG, tag);
        wenXueFragment.setArguments(args);
        new WenXuePresenter(wenXueFragment);
        return wenXueFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_wenxue;
    }

    @Override
    protected void initData() {
        //初始化网络请求的参数
        mParams = new RequestParamsBean();
        mParams.tag = getArguments().getString(TAG);
        mParams.start = 0;
        mParams.count = 18;
    }

    @Override
    protected void initialize() {
        mPresenter.start();
    }

    @Override
    protected void requestPermissionSucceed() {
        //正式开始网络请求
       mSubscription = mPresenter.requestData(mParams);
    }

    @Override
    protected void resetRequest() {
        mSubscription = mPresenter.requestData(mParams);
    }

    @Override
    public void showBookContent(final BookDataBean dataBean) {
        //数据展示
        BookWenXueAdapter wenXueAdapter = new BookWenXueAdapter(R.layout.item_fragment_wen_xue, dataBean.books);
        mRclWenXue.setLayoutManager(new GridLayoutManager(mContext,3));
        mRclWenXue.setAdapter(wenXueAdapter);
        wenXueAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), BookDetailActivity.class);
                intent.putExtra(BOOKBEAN,dataBean);
                intent.putExtra(POSITION,position);
                startActivity(intent);
            }
        });
    }
}
