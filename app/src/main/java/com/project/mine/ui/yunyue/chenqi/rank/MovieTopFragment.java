package com.project.mine.ui.yunyue.chenqi.rank;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.Top250Adapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.movie.SubjectsBean;
import com.project.mine.ui.yunyue.chenqi.detail.DetailActivity;

import java.util.List;

import butterknife.BindView;

/**
 * Created by chenqi on 2017/4/26.
 * 描述:
 */
public class MovieTopFragment extends BaseNetFragment<MovieTopContract.Presenter>
        implements MovieTopContract.View {

    @BindView(R.id.rcl_movie_content)
    RecyclerView mRclMovieContent;

    public static MovieTopFragment newInstance() {
        MovieTopFragment movieTopFragment = new MovieTopFragment();
        new MovieTopPresenter(movieTopFragment);
        return movieTopFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_movie_top;
    }

    @Override
    protected void initData() {
        mParams = new RequestParamsBean();
        mParams.start = 0;
        mParams.count = 18;
    }

    @Override
    protected void initialize() {
        mPresenter.start();
    }

    @Override
    protected void requestPermissionSucceed() {
        mSubscription = mPresenter.requestData(mParams);
    }

    @Override
    protected void resetRequest() {
        mSubscription = mPresenter.requestData(mParams);
    }

    @Override
    public void showTop250Movies(final List<SubjectsBean> subjectsBeanList) {
        Top250Adapter adapter = new Top250Adapter(R.layout.item_fragment_wen_xue, subjectsBeanList);
        mRclMovieContent.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRclMovieContent.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_fragment_wen_xue, null);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_book_photo);
                SubjectsBean subjectsBean = subjectsBeanList.get(position);
                DetailActivity.start(getActivity(), subjectsBean, imageView);
            }
        });
    }
}
