package com.zhuancheng.sanhedefence.presentation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.zhuancheng.sanhedefence.R;

/**
 * Created by cong on 2017/5/12.
 */

public class PhotoRequire extends BaseActivity {
    private TextView photoContent, photo_require;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_photo_require);
        super.onCreate(savedInstanceState);
        setActionTitle("");
        photoContent = (TextView) findViewById(R.id.photoContent);
        photo_require = (TextView) findViewById(R.id.photo_require);

        String partName = getIntent().getStringExtra("partName");
        photoContent.setText(partName);
        
    }
}
