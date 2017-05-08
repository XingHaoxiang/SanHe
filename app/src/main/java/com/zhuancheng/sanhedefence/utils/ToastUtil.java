package com.zhuancheng.sanhedefence.utils;

import android.content.Context;
import android.widget.Toast;

import com.zhuancheng.sanhedefence.application.SanHeDefenceApplication;

/**
 * Created by cong on 2017/5/8.
 */

public class ToastUtil {
    public static final int TIME_SHORT = Toast.LENGTH_SHORT;
    public static final int TIME_LONG = Toast.LENGTH_LONG;

    private static Toast mToast;
    private static Context mContext = SanHeDefenceApplication.getContext();

    public static void showToast(int resId) {
        showToast(mContext.getResources().getString(resId));
    }

    public static void showToast(String text) {
        showToast(text, TIME_SHORT);
    }

    public static void showToast(int resId, int duration) {
        showToast(mContext.getResources().getString(resId), duration);
    }

    public static void showToast(String text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, text, duration);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }
}
