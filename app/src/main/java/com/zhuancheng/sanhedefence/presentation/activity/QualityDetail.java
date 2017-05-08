package com.zhuancheng.sanhedefence.presentation.activity;

import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.zhuancheng.sanhedefence.R;


public class QualityDetail extends BaseActivity {
    private MapView bmapView;
    private BaiduMap baiduMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_quality_detail);
        super.onCreate(savedInstanceState);
        setActionTitle("质监任务详情");
        bmapView = (MapView) findViewById(R.id.bmapView);
        baiduMap = bmapView.getMap();
        bmapView.showZoomControls(false);
        bmapView.showScaleControl(false);
        bmapView.setEnabled(false);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bmapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bmapView.onDestroy();
    }
}
