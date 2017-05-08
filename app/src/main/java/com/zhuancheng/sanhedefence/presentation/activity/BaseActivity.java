package com.zhuancheng.sanhedefence.presentation.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuancheng.sanhedefence.R;

/**
 * Created by cong on 2017/5/4.
 */
public class BaseActivity extends AppCompatActivity{
    private Toolbar toolbar;
    TextView mTextView;
    ImageView leftImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.action_toolbar);
        mTextView = (TextView) findViewById(R.id.action_title);
        leftImageView = (ImageView) findViewById(R.id.action_left_image);
        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void setActionTitle(String title) {
        if (TextUtils.isEmpty(title)) {
            throw new IllegalArgumentException("传入的标题不能为空");
        } else {
            mTextView.setText(title);
        }
    }

    protected void setActionTitle(int res) {
        setActionTitle(getResources().getText(res).toString());
    }

    protected void setLeftImage(int res) {
        leftImageView.setImageBitmap(BitmapFactory.decodeResource(getResources(), res));
    }



}
