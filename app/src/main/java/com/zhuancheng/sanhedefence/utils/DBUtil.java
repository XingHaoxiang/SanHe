package com.zhuancheng.sanhedefence.utils;

import android.content.Context;
import android.util.Log;

import com.zhuancheng.sanhedefence.domain.constants.Const;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by cont on 2016/5/10.
 */
public class DBUtil {
    private static final String TAG = "DBUtil";
    public static File dbFile;

    static {
        String dbPath = Const.DBPATH;
        dbFile = new File(dbPath);

        if (!dbFile.exists()) {
            dbFile.mkdir(); // 创建路径

        }

        dbFile = new File(dbPath, "sanhedb.db");

    }
    // 路径

    /**
     * 判断是否有数据库
     * 存在返回true
     */
    public static boolean isExist() {
        if (!dbFile.exists() || dbFile.length() <= 0)
            return false;
        else
            return true;
    }

    /**
     * 导数据到内存中
     */
    public static void copyDb2Memory(Context context, String fromPath, File toPath) throws IOException {
        InputStream is = context.getAssets().open(fromPath);
        BufferedInputStream bis = new BufferedInputStream(is);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(toPath, false));

        int len = 0;
        byte[] buff = new byte[2 * 1024];
        while ((len = bis.read(buff)) != -1) {
            bos.write(buff, 0, len);
        }
        Log.d(TAG, "copyDb2Memory: " + "写入成功");
        bos.flush(); 
        bos.close();
        bis.close();
        is.close();
    }
}
