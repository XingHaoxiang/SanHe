package com.zhuancheng.sanhedefence.presentation.weiget;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

import com.yanzhenjie.album.UIWrapper;

import java.util.ArrayList;

/**
 * Created by cong on 2017/5/11.
 */

public class ImageWrapper extends UIWrapper<ImageWrapper> {

    static final String KEY_INPUT_FRAMEWORK_FUNCTION = "KEY_INPUT_FRAMEWORK_FUNCTION";
    static final int VALUE_INPUT_FRAMEWORK_FUNCTION_ALBUM = 0;
    static final int VALUE_INPUT_FRAMEWORK_FUNCTION_GALLERY = 1;
    static final int VALUE_INPUT_FRAMEWORK_FUNCTION_CAMERA = 2;

    public static final String KEY_INPUT_CHECK_FUNCTION = "KEY_INPUT_CHECK_FUNCTION";
    public static final String KEY_INPUT_CURRENT_POSITION = "KEY_INPUT_CURRENT_POSITION";
    public static final String KEY_INPUT_TITLE_LIST = "KEY_INPUT_TITLE_LIST";

    private Intent intent;

    ImageWrapper(Object o) {
        this(o, new Intent(getContext(o), ImageActivity.class), VALUE_INPUT_FRAMEWORK_FUNCTION_GALLERY);
    }

    private ImageWrapper(Object o, Intent intent, int function) {
        super(o, intent, function);
        this.intent = intent;
    }

    @Override
    public ImageWrapper requestCode(int requestCode) {
        intent.putExtra(KEY_INPUT_REQUEST_CODE, requestCode);
        return this;
    }

    @Override
    public ImageWrapper statusBarColor(@ColorInt int color) {
        intent.putExtra(KEY_INPUT_STATUS_COLOR, color);
        return this;
    }

    @Override
    public ImageWrapper toolBarColor(@ColorInt int color) {
        intent.putExtra(KEY_INPUT_TOOLBAR_COLOR, color);
        return this;
    }

    @Override
    public ImageWrapper navigationBarColor(@ColorInt int color) {
        intent.putExtra(KEY_INPUT_NAVIGATION_COLOR, color);
        return this;
    }

    @Override
    public ImageWrapper checkedList(@NonNull ArrayList<String> pathList) {
        intent.putStringArrayListExtra(KEY_INPUT_CHECKED_LIST, pathList);
        return this;
    }

    public ImageWrapper titleList(@NonNull ArrayList<String> nameList) {
        intent.putStringArrayListExtra(KEY_INPUT_TITLE_LIST, nameList);
        return this;
    }

    public ImageWrapper checkFunction(boolean check) {
        intent.putExtra(KEY_INPUT_CHECK_FUNCTION, check);
        return this;
    }

    public ImageWrapper currentPosition(int position) {
        intent.putExtra(KEY_INPUT_CURRENT_POSITION, position);
        return this;
    }
}
