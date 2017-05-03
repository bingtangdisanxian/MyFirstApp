package com.project.mine.ui.home.home;

import com.google.gson.reflect.TypeToken;
import com.project.mine.bean.home.tablayout.LiveCategory;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.rx.TransformUtils;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:首页部分的P层
 */
public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    public HomePresenter(HomeContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }

    @Override
    public Subscription requestData(RequestParamsBean params) {
        return AppManager.getInstance().getRecommendApi().getAllCategories()
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2ListData)
                .subscribe(new Action1<List<LiveCategory>>() {
                    @Override
                    public void call(List<LiveCategory> liveCategories) {
                        mView.showTabLayout(liveCategories);
                        mView.onLoadSuccess();
                    }
                }, mOnError);
    }

    //将json数据转换为对象
    private Func1<ResponseBody, List<LiveCategory>> json2ListData = new Func1<ResponseBody, List<LiveCategory>>() {
        @Override
        public List<LiveCategory> call(ResponseBody responseBody) {
            return parseRequestData(responseBody);
        }
    };

    //加载失败
    private Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            mView.onLoadError(getClass().getSimpleName(), throwable);
        }
    };

    //解析json
    private List<LiveCategory> parseRequestData(ResponseBody responseBody) {
        List<LiveCategory> liveCategories = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(responseBody.string());
            Type token = new TypeToken<List<LiveCategory>>() {
            }.getType();
            liveCategories = JsonUtil.parseJson(jsonArray.toString(),token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liveCategories;
    }

    @Override
    public void start() {
        mView.onLoading();
    }
}
