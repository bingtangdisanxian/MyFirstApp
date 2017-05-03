package com.project.mine.base.app;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;


/**
 * Created by chenqi on 2017/4/9.
 * 描述:程序的入口,初始化一些全局变量
 */
public class BaseApplication extends Application {

    private static BaseApplication mContext;    //上下文
    private static Thread mMainThread;  //主线程
    private static long mMainThreadId;  //主线程id
    private static Looper mMainLooper;  //循环队列
    private static Handler mHandler;    //主线程Handler

    @Override
    public void onCreate() {
        super.onCreate();
        initWholeVar();
//        initLeakCanary();
    }

    private void initWholeVar() {
        mContext = this;
        mMainThread = Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        mMainLooper = getMainLooper();
        mHandler = new Handler();
    }

//    private void initLeakCanary() {
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);
//    }

    public static BaseApplication getmContext() {
        return mContext;
    }

    public static Thread getmMainThread() {
        return mMainThread;
    }

    public static long getmMainThreadId() {
        return mMainThreadId;
    }

    public static Looper getmMainLooper() {
        return mMainLooper;
    }

    public static Handler getmHandler() {
        return mHandler;
    }
}
