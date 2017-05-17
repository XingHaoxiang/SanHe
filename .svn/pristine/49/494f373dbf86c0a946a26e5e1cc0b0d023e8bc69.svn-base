package com.zhuancheng.sanhedefence.presentation.weiget;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.UIWrapper;
import com.yanzhenjie.album.impl.GalleryCallback;
import com.yanzhenjie.album.util.AlbumUtils;
import com.yanzhenjie.album.util.DisplayUtils;
import com.yanzhenjie.fragment.CompatActivity;
import com.yanzhenjie.fragment.NoFragment;
import com.zhuancheng.sanhedefence.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by cong on 2017/5/11.
 */

public class ImageActivity extends CompatActivity implements GalleryCallback {
    private static final int PERMISSION_REQUEST_STORAGE_ALBUM = 200;
    private static final int PERMISSION_REQUEST_STORAGE_GALLERY = 201;
    static final String KEY_INPUT_FRAMEWORK_FUNCTION = "KEY_INPUT_FRAMEWORK_FUNCTION";

    private List<String> mCheckedPaths;
    private List<String> mTitleName;
    private Bundle mArgument;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayUtils.initScreen(this);
        Locale locale = Album.getAlbumConfig().getLocale();
        AlbumUtils.applyLanguageForContext(this, locale);
        setContentView(R.layout.image_activity);
        Intent intent = getIntent();
        mArgument = intent.getExtras();

        int statusBarColor = intent.getIntExtra(UIWrapper.KEY_INPUT_STATUS_COLOR,
                ContextCompat.getColor(this, com.yanzhenjie.album.R.color.albumColorPrimaryDark));
        int navigationBarColor = intent.getIntExtra(UIWrapper.KEY_INPUT_NAVIGATION_COLOR,
                ContextCompat.getColor(this, com.yanzhenjie.album.R.color.albumColorPrimaryBlack));
        mCheckedPaths = intent.getStringArrayListExtra(UIWrapper.KEY_INPUT_CHECKED_LIST);
        mTitleName = intent.getStringArrayListExtra(ImageWrapper.KEY_INPUT_TITLE_LIST);
        setWindowBarColor(statusBarColor, navigationBarColor);

        // Function dispatch.
        final int function = intent.getIntExtra(ImageWrapper.KEY_INPUT_FRAMEWORK_FUNCTION,
                ImageWrapper.VALUE_INPUT_FRAMEWORK_FUNCTION_ALBUM);
        switch (function) {

            case ImageWrapper.VALUE_INPUT_FRAMEWORK_FUNCTION_GALLERY: {
                if (mCheckedPaths == null || mCheckedPaths.size() == 0) finish();
                else requestPermission(PERMISSION_REQUEST_STORAGE_GALLERY);
                break;
            }

            default: {
                finish();
                break;
            }
        }
    }

    private void requestPermission(int requestCode) {
        if (Build.VERSION.SDK_INT >= 23) {
            int permissionResult = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionResult == PackageManager.PERMISSION_GRANTED) {
                onRequestPermissionsResult(
                        requestCode,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        new int[]{PackageManager.PERMISSION_GRANTED});
            } else if (permissionResult == PackageManager.PERMISSION_DENIED) {
                ActivityCompat.requestPermissions(
                        this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE},
                        requestCode);
            }
        } else {
            onRequestPermissionsResult(
                    requestCode,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    new int[]{PackageManager.PERMISSION_GRANTED});
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_STORAGE_GALLERY: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ImageFragment imageFragment = NoFragment.instantiate(this, ImageFragment.class, mArgument);
                    imageFragment.bindImagePaths(mCheckedPaths);
                    imageFragment.bindImageDes(mTitleName);
                    startFragment(imageFragment);
                }
//                else {
//                    onAlbumResult(new ArrayList<>(mCheckedPaths));
//                }
                break;
            }
        }
    }

    @Override
    protected int fragmentLayoutId() {
        return R.id.image_layout;
    }

    private void setWindowBarColor(@ColorInt int statusColor, @ColorInt int navigationColor) {
        if (Build.VERSION.SDK_INT >= 21) {
            final Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(statusColor);
            window.setNavigationBarColor(navigationColor);
        }
    }

    @Override
    public void onGalleryResult(ArrayList<String> imagePathList) {

    }

    @Override
    public void onGalleryCancel() {

    }
}
