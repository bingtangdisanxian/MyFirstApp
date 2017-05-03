package com.project.mine.ui.yunyue.zhongyuan.welfare;

import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.music.WelfareBean;
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
 * @time 2017/4/26  22:49
 * @desc ${TODD}
 */

public class WelfarePresenter implements WelfareContract.Presenter {

    private WelfareContract.View mView;

    public WelfarePresenter(WelfareContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }


    @Override
    public Subscription requestData(RequestParamsBean params) {

        return AppManager.getInstance().getGankIOServer().getGankIoData("福利"
                , params.dataCount, params.requestPages)
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2Str)
                .subscribe(new Action1<WelfareBean>() {
                    @Override
                    public void call(WelfareBean welfareBean) {
                        mView.showPic(welfareBean);
                        mView.onLoadSuccess();
                    }
                }, mOnError);
    }

    Func1<ResponseBody, WelfareBean> json2Str = new Func1<ResponseBody, WelfareBean>() {
        @Override
        public WelfareBean call(ResponseBody responseBody) {
            return parseData(responseBody);
        }
    };

    private WelfareBean parseData(ResponseBody responseBody) {
        WelfareBean welfareBean = null;
        try {
            String string = responseBody.string();
            welfareBean = JsonUtil.parseJson(string, WelfareBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return welfareBean;
    }

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
