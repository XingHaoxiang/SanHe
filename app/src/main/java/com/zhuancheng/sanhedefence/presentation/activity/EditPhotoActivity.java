package com.zhuancheng.sanhedefence.presentation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zhuancheng.sanhedefence.R;

public class EditPhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);

        String partName = getIntent().getStringExtra("partName");

    }
}
