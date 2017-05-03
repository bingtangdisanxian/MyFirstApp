package com.project.mine.ui.yunyue.chenqi.movie;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.project.mine.R;
import com.project.mine.adapter.yunyue.MovieAdapter;
import com.project.mine.base.mvp.BaseNetFragment;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.movie.SubjectsBean;
import com.project.mine.constant.ConstantsImageUrl;
import com.project.mine.ui.yunyue.chenqi.detail.LatestDetailActivity;
import com.project.mine.ui.yunyue.chenqi.rank.MovieTopActivity;
import com.project.mine.util.ImageUtil;
import com.project.mine.util.IntentUtils;

import java.util.List;

import butterknife.BindView;

import static com.project.mine.ui.yunyue.chenqi.detail.LatestDetailActivity.SUBJECT_BEAN;

/**
 * Created by chenqi on 2017/4/25.
 * 描述:
 */
public class MovieFragment extends BaseNetFragment<MovieContract.Presenter> implements
        MovieContract.View {

    @BindView(R.id.rcl_movie)
    RecyclerView mRclMovie;
    private View mHeadView;
    private MovieAdapter mMovieAdapter;

    public static MovieFragment newInstance() {
        MovieFragment movieFragment = new MovieFragment();
        new MoviePresenter(movieFragment);
        return movieFragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initData() {
        mParams = new RequestParamsBean();

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
    public void showResult(final List<SubjectsBean> mListSubjectBean) {
        //展示数据
        mMovieAdapter = new MovieAdapter(R.layout.item_fragment_movie, mListSubjectBean);
        mRclMovie.setLayoutManager(new LinearLayoutManager(mContext));
        mRclMovie.setAdapter(mMovieAdapter);
        setHeadView();

        mMovieAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, LatestDetailActivity.class);
                SubjectsBean subjectsBean = mListSubjectBean.get(position);
                intent.putExtra(SUBJECT_BEAN, subjectsBean);
                startActivity(intent);
            }
        });
    }

    private void setHeadView() {
        if (mHeadView == null && mMovieAdapter != null) {
            mHeadView = LayoutInflater.from(mContext).inflate(R.layout.item_movie_head, null);
            View llMovieTop = mHeadView.findViewById(R.id.ll_movie_top);
            ImageView ivImg = (ImageView) mHeadView.findViewById(R.id.iv_img);
            ImageUtil.displayRandom(3, ConstantsImageUrl.ONE_URL_01, ivImg);
            mMovieAdapter.addHeaderView(mHeadView);
            llMovieTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //处理头部的点击事件
                    IntentUtils.startActivity(getActivity(), MovieTopActivity.class);
                }
            });
        }
    }
}
