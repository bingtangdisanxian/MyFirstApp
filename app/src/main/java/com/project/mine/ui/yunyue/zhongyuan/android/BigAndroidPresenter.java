package com.project.mine.ui.yunyue.zhongyuan.android;

import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.music.BigAndroidBean;
import com.project.mine.bean.yunyue.music.WelfareBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.rx.TransformUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author 钟教授
 * @time 2017/4/27  13:46
 * @desc ${TODD}
 */

public class BigAndroidPresenter implements BigAndroidContract.Presenter {


    private BigAndroidContract.View mView;

    public BigAndroidPresenter(BigAndroidContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }


    @Override
    public Subscription requestData(RequestParamsBean params) {

        return AppManager.getInstance().getGankIOServer().getGankIoData("Android"
        ,params.dataCount,params.requestPages)
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2Str)
                .subscribe(new Action1<BigAndroidBean>() {
                    @Override
                    public void call(BigAndroidBean bigAndroidBean) {
                        mView.showItem(bigAndroidBean);
                        mView.onLoadSuccess();
                    }
                }, mOnError);
    }

    Func1<ResponseBody, BigAndroidBean> json2Str =new Func1<ResponseBody, BigAndroidBean>() {
        @Override
        public BigAndroidBean call(ResponseBody responseBody) {
            BigAndroidBean bigAndroidBean = null;
            try {
                String string = responseBody.string();
                bigAndroidBean = JsonUtil.parseJson(string, BigAndroidBean.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bigAndroidBean;
        }
    };

    //加载失败
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
