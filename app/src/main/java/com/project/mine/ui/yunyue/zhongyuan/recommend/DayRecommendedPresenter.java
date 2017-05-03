package com.project.mine.ui.yunyue.zhongyuan.recommend;


import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.bean.yunyue.movie.MovieBean;
import com.project.mine.bean.yunyue.movie.SubjectsBean;
import com.project.mine.bean.yunyue.music.EveryDayBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.rx.TransformUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * @author 钟教授
 * @time 2017/4/26  13:56
 * @desc ${TODD}
 */

public class DayRecommendedPresenter implements DayRecommendedContract.Presenter {

    private DayRecommendedContract.View mView;

    public DayRecommendedPresenter(DayRecommendedContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }



    @Override
    public Subscription requestContentData(RequestParamsBean params) {
        return AppManager.getInstance().getDouBanService().getHotMovie()
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2ListData)
                .subscribe(new Action1<List<SubjectsBean>>() {
                    @Override
                    public void call(List<SubjectsBean> subjectsBeanList) {
                        mView.showResult(subjectsBeanList);
                        mView.onLoadSuccess();
                    }
                }, mOnError);
    }

    private Func1<ResponseBody, List<SubjectsBean>> json2ListData = new Func1<ResponseBody, List<SubjectsBean>>() {
        @Override
        public List<SubjectsBean> call(ResponseBody response) {
            return parseRequetData(response);
        }
    };

    private List<SubjectsBean> parseRequetData(ResponseBody response) {
        MovieBean movieBean = null;
        try {
            String string = response.string();
            movieBean = JsonUtil.parseJson(string, MovieBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieBean.subjects;
    }


    //banner网络请求
    @Override
    public Subscription requestData(RequestParamsBean params) {
        return AppManager.getInstance().getTingServer().getFrontpage()
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2Str)
                .subscribe(new Action1<EveryDayBean>() {
                    @Override
                    public void call(EveryDayBean everyDayBean) {
                        List<EveryDayBean.ResultBeanXXXXXXXXXXXXXXX.FocusBean.ResultBeanXXX> bannerBean = everyDayBean.getResult().getFocus().getResult();
                        mView.showBanner();
                        mView.onLoadSuccess();
                    }
                }, mOnError);
    }
    Func1<ResponseBody, EveryDayBean> json2Str = new Func1<ResponseBody, EveryDayBean>() {
        @Override
        public EveryDayBean call(ResponseBody responseBody) {
            return parseRequestData(responseBody);
        }
    };

    private EveryDayBean parseRequestData(ResponseBody responseBody) {
        EveryDayBean everyDayBean = null;
        try {
            String string = responseBody.string();
            everyDayBean = JsonUtil.parseJson(string, EveryDayBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return everyDayBean;
    }

    //加载失败
    private Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            mView.onLoadSuccess();
            mView.showBanner();
        }
    };

    @Override
    public void start() {
        mView.onLoading();
    }


}
