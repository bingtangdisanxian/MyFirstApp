package com.project.mine.ui.home.tablayout;

import com.google.gson.reflect.TypeToken;
import com.project.mine.bean.home.banner.BannerBean;
import com.project.mine.bean.home.module.DataBean;
import com.project.mine.bean.home.module.RoomBean;
import com.project.mine.bean.request.RequestParamsBean;
import com.project.mine.data.net.AppManager;
import com.project.mine.util.JsonUtil;
import com.project.mine.util.rx.TransformUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by chenqi on 2017/4/13.
 * 描述:首页的外层Fragment的实现
 */
public class RecommendPresenter implements RecommendContract.Presenter {

    private RecommendContract.View mView;

    public RecommendPresenter(RecommendContract.View view) {
        mView = view;
        mView.initPresenter(this);
    }

    @Override
    public Subscription requestData(final RequestParamsBean params) {
        return AppManager.getInstance().getRecommendApi().getRecommendCategories()
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2ListData)
                .subscribe(new Action1<DataBean>() {
                    @Override
                    public void call(DataBean dataBean) {
                        //小版块的数目,具体数据包含在roomBean中
                        List<RoomBean> roomBeen = dataBean.room;
                        mView.showListModule(roomBeen);
                        mView.onLoadSuccess();
                        if (params.mLayout != null && params.mLayout.isRefreshing()) {
                            params.mLayout.refreshComplete();
                        }
                    }
                }, mOnError);
    }

    private Func1<ResponseBody, DataBean> json2ListData = new Func1<ResponseBody, DataBean>() {
        @Override
        public DataBean call(ResponseBody response) {
            return parseRequestData(response);
        }
    };

    private DataBean parseRequestData(ResponseBody response) {
        DataBean dataBean = null;
        try {
            String string = response.string();
            dataBean = JsonUtil.parseJson(string, DataBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataBean;
    }

    @Override
    public void start() {

    }

    //加载失败
    private Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            mView.onLoadError(getClass().getSimpleName(), throwable);
        }
    };


    //请求轮播图数据
    @Override
    public Subscription requestBannerData() {

        return AppManager.getInstance().getRecommendApi().getAppStartInfo()
                .compose(TransformUtils.<ResponseBody>defaultSchedulers())
                .map(json2ListData2)
                .subscribe(new Action1<List<BannerBean>>() {
                    @Override
                    public void call(List<BannerBean> bannerBeen) {
                        mView.showBanner(bannerBeen);//展示轮播图
                    }
                }, mOnError);
    }

    private Func1<ResponseBody, List<BannerBean>> json2ListData2 = new Func1<ResponseBody, List<BannerBean>>() {
        @Override
        public List<BannerBean> call(ResponseBody response) {
            return parseJsonData(response);
        }
    };

    private List<BannerBean> parseJsonData(ResponseBody response) {
        List<BannerBean> banners = new ArrayList<>();
        try {
            String jsonStr = response.string();
            JSONObject jsonObject = new JSONObject(jsonStr);
            JSONArray jsonArray = jsonObject.optJSONArray("app-focus");
            Type type = new TypeToken<List<BannerBean>>() {
            }.getType();
            if (jsonArray != null) {
                banners = JsonUtil.parseJson(jsonArray.toString(), type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return banners;
    }
}
