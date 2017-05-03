package com.project.mine.data.net;

import android.support.annotation.NonNull;

import com.project.mine.data.net.api.RecommendApi;
import com.project.mine.data.net.api.YunYueApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenqi on 2017/4/9.
 * 描述:通过Retrofit管理网络请求的API
 */
@SuppressWarnings("all")
public class AppManager {

    private static AppManager instance;
    private Object gankHttps, doubanHttps, dongtingHttps, quanminHttps;
    private final static String API_QUANMIN = "https:www.quanmin.tv/";
    private final static String API_GANKIO = "https://gank.io/api/";
    private final static String API_DOUBAN = "Https://api.douban.com/";
    private final static String API_TING = "https://tingapi.ting.baidu.com/v1/restserver/";

    public static AppManager getInstance() {
        if (instance == null) {
            synchronized (AppManager.class) {
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    public <T> T getGankIOServer(Class<T> a) {
        if (gankHttps == null) {
            synchronized (AppManager.class) {
                if (gankHttps == null) {
                    gankHttps = getRetrofit(API_GANKIO).create(a);
                }
            }
        }
        return (T) gankHttps;
    }

    public <T> T getDouBanServer(Class<T> a) {
        if (doubanHttps == null) {
            synchronized (AppManager.class) {
                if (doubanHttps == null) {
                    doubanHttps = getRetrofit(API_DOUBAN).create(a);
                }
            }
        }
        return (T) doubanHttps;
    }

    public <T> T getTingServer(Class<T> a) {
        if (dongtingHttps == null) {
            synchronized (AppManager.class) {
                if (dongtingHttps == null) {
                    dongtingHttps = getRetrofit(API_TING).create(a);
                }
            }
        }
        return (T) dongtingHttps;
    }

    public <T> T getLiveServer(Class<T> a) {
        if (quanminHttps == null) {
            synchronized (AppManager.class) {
                if (quanminHttps == null) {
                    quanminHttps = getRetrofit(API_QUANMIN).create(a);
                }
            }
        }
        return (T) quanminHttps;
    }

    @NonNull
    private OkHttpClient getClient(HttpLoggingInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)//设置应用拦截器，可用于设置公共参数，头信息，日志拦截等
                .retryOnConnectionFailure(true)//错误重连
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
    }

    private Retrofit getRetrofit(String apiUrl) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Retrofit.Builder retrofit = new Retrofit.Builder();
        return retrofit.client(getClient(interceptor))
                .baseUrl(apiUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//提供RxJava支持
                .addConverterFactory(GsonConverterFactory.create())//提供Gson支持(尽量放在最后)
                .build();
    }

    public RecommendApi getRecommendApi() {
        return getLiveServer(RecommendApi.class);
    }

    public YunYueApi getDouBanService() {
        return getDouBanServer(YunYueApi.class);
    }

    public YunYueApi getTingServer() {
        return getTingServer(YunYueApi.class);
    }

    public YunYueApi getGankIOServer() {
        return getGankIOServer(YunYueApi.class);
    }
}
