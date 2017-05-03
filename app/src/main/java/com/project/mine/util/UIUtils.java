package com.project.mine.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;

import com.project.mine.base.app.BaseApplication;


/**
 * Created by chenqi on 2017/3/31.
 * 描述:全局的工具类
 */
@SuppressWarnings("ALL")
public class UIUtils {
    /**
     * 得到上下文
     */
    public static Context getContext() {
        return BaseApplication.getmContext();
    }

    /**
     * 得到Resource对象
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 得到string.xml中的字符
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 得到string.xml中的字符,带占位符
     */
    public static String getString(int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

    /**
     * 得到string.xml中的字符数组
     */
    public static String[] getStringArr(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 得到color.xml中的颜色值
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 得到应用程序的包名
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * 得到主线程的id
     */
    public static long getMainThreadId() {
        return BaseApplication.getmMainThreadId();
    }

    /**
     * 得到主线程的handler
     */
    public static Handler getHandler() {
        return BaseApplication.getmHandler();
    }

    /**
     * 安全的执行一个task
     */
    public static void postTaskSafely(Runnable task) {
        // 得到当前线程的id
        long curThreadId = android.os.Process.myTid();
        long mainThreadId = getMainThreadId();
        if (curThreadId == mainThreadId) {
            // 如果调用该方法的线程是在主线程-->直接执行任务
            task.run();
        } else {
            // 如果调用该方法的线程是在子线程-->把任务post到主线程handler去执行
            // 主线程的handler
            Handler handler = getHandler();
            handler.post(task);
        }
    }

    /**
     * dip-->px
     */
    public static int dip2Px(int dip) {
        // px/dp = density
        // px/(ppi/160) = px
        float density = getResources().getDisplayMetrics().density;//1.5
        int ppi = getResources().getDisplayMetrics().densityDpi;//240
        int px = (int) (dip * density + .5f);
        return px;
    }

    /**
     * px-->dip
     */
    public static int px2Dip(int px) {
        // px/dp = density
        float density = getResources().getDisplayMetrics().density;//1.5
        int dp = (int) (px / density + .5f);
        return dp;
    }
}
