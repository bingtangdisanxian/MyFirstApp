package com.project.mine.ui.yunyue.shuaishuai.wenxue;

import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.book.BookDataBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.rx.TransformUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by Gnices on 2017/4/26.
 */

public class WenXuePresenter implements WenXueContract.Presenter {

    private WenXueContract.View mView;

    public WenXuePresenter(WenXueContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }

    @Override
    public Subscription requestData(RequestParamsBean params) {
        //网络请求
        return AppManager.getInstance().getDouBanService()
                .getBook(params.tag, params.start, params.count)
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2ListData)
                .subscribe(new Action1<BookDataBean>() {
                    @Override
                    public void call(BookDataBean dataBean) {
                        mView.showBookContent(dataBean);
                        mView.onLoadSuccess();
                    }
                },mOnError);
    }

    private Func1<ResponseBody, BookDataBean> json2ListData = new Func1<ResponseBody, BookDataBean>() {
        @Override
        public BookDataBean call(ResponseBody response) {
            return parseRequestData(response);
        }
    };

    private Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            mView.onLoadError(getClass().getSimpleName(), throwable);
        }
    };

    private BookDataBean parseRequestData(ResponseBody response) {
        BookDataBean dataBean = null;
        try {
            String string = response.string();
            dataBean = JsonUtil.parseJson(string, BookDataBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataBean;
    }

    @Override
    public void start() {
        mView.onLoading();
    }
}
