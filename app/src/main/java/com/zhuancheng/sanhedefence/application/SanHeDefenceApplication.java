package com.zhuancheng.sanhedefence.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by cong on 2017/5/4.
 */
public class SanHeDefenceApplication extends Application {

    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
