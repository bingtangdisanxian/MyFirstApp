package com.project.mine.base.mvp;

import com.project.mine.bean.request.RequestParamsBean;

import rx.Subscription;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:综合管理P和V层的契约接口
 */
public interface BaseContract {

    interface View extends IBaseView<Presenter> {

        void onLoading();

        void onLoadSuccess();

        void onLoadError(String msg, Throwable e);
    }

    interface Presenter extends IBasePresenter {

        Subscription requestData(RequestParamsBean params);

    }
}
