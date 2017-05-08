package com.zhuancheng.sanhedefence.application;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by cong on 2017/5/4.
 */
public class SanHeDefenceApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        SDKInitializer.initialize(getApplicationContext());
    }

    public static Context getContext(){
        return mContext;
    }
}
