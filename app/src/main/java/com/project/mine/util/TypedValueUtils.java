package com.project.mine.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.util.TypedValue;

/**
 * 转标准尺寸的工具类
 */

public class TypedValueUtils {

    public static float getTypedValueInDP(Context context, float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, context.getResources().getDisplayMetrics());
    }

    public static float getTypedValueInSP(Context context, float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, context.getResources().getDisplayMetrics());
    }

    public static TypedArray getStyleValuesColor(Context context, @AttrRes int attrId, int style) {
        TypedArray a = null;
        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
        }
        return a;
    }

    public static int getStyleValuesInt(Context context, @AttrRes int attrId, int style) {
        TypedArray a = null;
        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            a.recycle();
        }
        return a.getInt(0, 0);
    }

    public static String getStyleValuesString(Context context, @AttrRes int attrId, int style) {
        TypedArray a = null;
        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            a.recycle();
        }
        return a.getString(0);
    }

    public static boolean getStyleValuesBoolean(Context context, @AttrRes int attrId, int style) {
        TypedArray a = null;
        if (style > 0) {
            int[] AttrSet = {attrId};
            a = context.obtainStyledAttributes(style, AttrSet);
            a.recycle();
        }
        return a.getBoolean(0, false);
    }
}
