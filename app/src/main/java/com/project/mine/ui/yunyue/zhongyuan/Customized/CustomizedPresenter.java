package com.project.mine.ui.yunyue.zhongyuan.Customized;

import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.music.CustomizedBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.rx.TransformUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author 钟教授
 * @time 2017/4/27  18:31
 * @desc ${TODD}
 */

public class CustomizedPresenter implements CustomizedConteact.Presenter {


    private CustomizedConteact.View mView;

    public CustomizedPresenter(CustomizedConteact.View view) {
        mView = view;
        mView.initPresenter(this);
    }


    @Override
    public Subscription requestData(RequestParamsBean params) {

        return AppManager.getInstance().getGankIOServer().getGankIoData(params.type, params.requestPages, params.dataCount)
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2Str)
                .subscribe(new Action1<CustomizedBean>() {
                    @Override
                    public void call(CustomizedBean bean) {
                        mView.showResult(bean);
                        mView.onLoadSuccess();
                    }
                }, mOnError);
    }

    Func1<ResponseBody, CustomizedBean> json2Str = new Func1<ResponseBody, CustomizedBean>() {
        @Override
        public CustomizedBean call(ResponseBody responseBody) {
            return parseRequestData(responseBody);
        }
    };

    private CustomizedBean parseRequestData(ResponseBody response) {
        CustomizedBean customizedBean = null;
        try {
            String string = response.string();
            customizedBean = JsonUtil.parseJson(string, CustomizedBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customizedBean;
    }

    private Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            mView.onLoadError(getClass().getSimpleName(), throwable);
        }
    };


    @Override
    public void start() {
        mView.onLoading();
    }
}
