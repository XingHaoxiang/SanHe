package com.zhuancheng.sanhedefence.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.zhuancheng.sanhedefence.domain.constants.Const;
import com.zhuancheng.sanhedefence.utils.DBUtil;
import com.zhuancheng.sanhedefence.utils.ShareData;

import java.io.IOException;

/**
 * Created by cong on 2017/5/4.
 */
public class SanHeDefenceApplication extends Application {
    private static final String TAG = "SanHeDefenceApplication";
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        SDKInitializer.initialize(getApplicationContext());
        ShareData.init(mContext);
        if (!DBUtil.isExist()) {
            try {
                DBUtil.copyDb2Memory(getApplicationContext(), Const.DBNAME, DBUtil.dbFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.d(TAG, "onCreate: 数据库已经存在");
        }
    }

    public static Context getContext(){
        return mContext;
    }

}
