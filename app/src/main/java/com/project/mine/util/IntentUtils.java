package com.project.mine.util;

import android.app.Activity;
import android.content.Intent;

/**
 * 用来做页面跳转的工具类
 * 分为跳转和跳转后关闭原页面
 */

public class IntentUtils {
    //直接跳转到一个新的activity
    public static void startActivity(Activity activity, Class clazz){
        Intent intent=new Intent(activity,clazz);
        activity.startActivity(intent);
    }

    //跳转到一个新的activity,关闭当前的activity
    public static void startActivityAndFinish(Activity activity,Class clazz){
        Intent intent=new Intent(activity,clazz);
        activity.startActivity(intent);
        activity.finish();
    }

    //跳转到一个新的activity,并且返回数据
    public static void startActivityAndForResult(Activity activity,Class clazz){
        Intent intent=new Intent(activity,clazz);
        activity.startActivityForResult(intent,0);
    }
    //直接跳转到一个新的service
    public static void startService(Activity activity,Class clazz){
        Intent intent=new Intent(activity,clazz);
        activity.startService(intent);
    }
    //直接关闭service
    public static void stoptService(Activity activity,Class clazz){
        Intent intent=new Intent(activity,clazz);
        activity.stopService(intent);
    }
}
