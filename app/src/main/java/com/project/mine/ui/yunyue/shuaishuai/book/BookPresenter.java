package com.project.mine.ui.yunyue.shuaishuai.book;

import com.project.mine.bean.request.RequestParamsBean;

import rx.Subscription;

/**
 * Created by Gnices on 2017/4/26.
 */

public class BookPresenter implements BookContract.Presenter {

    private BookContract.View mView;

    public BookPresenter(BookContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }

    @Override
    public Subscription requestData(RequestParamsBean params) {
        return null;
    }

    @Override
    public void start() {

    }
}
