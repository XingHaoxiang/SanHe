package com.zhuancheng.sanhedefence.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cong on 2017/5/8.
 */

public class ShareData  {
    private static final String SP_NAME = "opc_sharedata";
    private static Context context;
    private static SharedPreferences sp;

    public static void init(Context initContext) {
        if (sp == null) {
            context = initContext;
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
    }
    public static void removeAll() {
        if (sp == null)
            return ;
        sp.edit().clear().apply();
    }

    public static int getShareIntData(String key) {
        if (sp == null)
            return 0;
        return sp.getInt(key, 0);
    }

    public static int getShareIntData(String key, int defValue) {
        if (sp == null)
            return 0;
        return sp.getInt(key, defValue);
    }

    public static void setShareIntData(String key, int value) {
        if (sp == null)
            return;
        sp.edit().putInt(key, value).apply();
    }

    public static String getShareStringData(String key) {
        if (sp == null)
            return "";
        return sp.getString(key, "");
    }

    public static String getShareStringData(String key, String value) {
        if (sp == null)
            return "";
        return sp.getString(key, value);
    }

    public static void setShareStringData(String key, String value) {
        if (sp == null)
            return;
        sp.edit().putString(key, value).apply();
    }

    public static boolean getShareBooleanData(String key) {
        if (sp == null)
            return false;
        return sp.getBoolean(key, false);
    }

    public static boolean getShareBooleanDataDefaultTrue(String key) {
        if (sp == null)
            return false;
        return sp.getBoolean(key, true);
    }

    public static void setShareBooleanData(String key, boolean value) {
        if (sp == null)
            return;
        sp.edit().putBoolean(key, value).apply();
    }

    public static float getShareFloatData(String key) {
        if (sp == null)
            return 0f;
        return sp.getFloat(key, 0f);
    }

    public static void setShareFloatData(String key, float value) {
        if (sp == null)
            return;
        sp.edit().putFloat(key, value).apply();
    }

    public static long getShareLongData(String key) {
        if (sp == null)
            return 0L;
        return sp.getLong(key, 0L);
    }

    public static void setShareLongData(String key, long value) {
        if (sp == null)
            return;
        sp.edit().putLong(key, value).apply();
    }

    public static void remove(String key) {
        if (sp == null)
            return;
        sp.edit().remove(key).apply();
    }

    public static boolean contains(String key) {
        if (sp == null)
            return false;
        return sp.contains(key);
    }
}
