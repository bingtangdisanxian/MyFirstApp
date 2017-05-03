package com.project.mine.data.net.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by chenqi on 2017/4/13.
 * 描述:
 */
public interface RecommendApi {

    @GET("json/page/app-data/info.json?v=2.2.4&os=1&ver=4")
    Observable<ResponseBody> getAppStartInfo();

    @GET("json/app/index/category/info-android.json?v=2.2.4&os=1&ver=4")
    Observable<ResponseBody> getAllCategories();

    @GET("json/app/index/recommend/list-android.json?11241742&v=2.2.4&os=1&ver=4")
    Observable<ResponseBody> getRecommendCategories();
}
