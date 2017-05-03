package com.project.mine.util;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonUtil {

    private static Gson sGson = null;

    public static <T> T parseJson(String json, Class<T> clazz) {
        T bean = null;
        if (sGson == null) {
            sGson = new Gson();
        }
        if (!TextUtils.isEmpty(json)) {
            bean = sGson.fromJson(json, clazz);
        }
        return bean;
    }
    public static <T> T parseJson(String json, Type token) {
        T bean = null;
        if (sGson == null) {
            sGson = new Gson();
        }
        if (!TextUtils.isEmpty(json)) {
            bean = sGson.fromJson(json, token);
        }
        return bean;
    }
}
