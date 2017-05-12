package com.zhuancheng.sanhedefence.presentation.weiget;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.yanzhenjie.album.AlbumConfig;
import com.yanzhenjie.album.task.LocalImageLoader;

import java.util.Locale;

/**
 * Created by cong on 2017/5/11.
 */

public final class ImageShow {
    public static String KEY_OUTPUT_IMAGE_PATH_LIST = "KEY_OUTPUT_IMAGE_PATH_LIST";
    public static String KEY_OUTPUT_TITLE_LIST = "KET_OUTPUT_TITLE_LIST";

    private static AlbumConfig sAlbumConfig;

    public static void initialize(AlbumConfig albumConfig) {
        sAlbumConfig = albumConfig;
    }

    public static AlbumConfig getAlbumConfig() {
        if (sAlbumConfig == null) {
            initialize(new AlbumConfig.Build()
                    .setImageLoader(new LocalImageLoader())
                    .setLocale(Locale.getDefault())
                    .build()
            );
        }
        return sAlbumConfig;
    }

    public static ImageWrapper gallery(Activity activity) {
        return new ImageWrapper(activity);
    }

    public static ImageWrapper gallery(Fragment fragment) {
        return new ImageWrapper(fragment);
    }

    public static ImageWrapper gallery(android.app.Fragment fragment) {
        return new ImageWrapper(fragment);
    }
}
