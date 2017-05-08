package com.zhuancheng.sanhedefence.presentation.activity;

import android.os.Bundle;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.zhuancheng.sanhedefence.R;


public class QualityDetail extends BaseActivity {
    private MapView bmapView;
    private BaiduMap baiduMap;
    private MapStatus mapStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_quality_detail);
        super.onCreate(savedInstanceState);
        setActionTitle("质监任务详情");
        bmapView = (MapView) findViewById(R.id.bmapView);
        baiduMapInit();
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

    private void baiduMapInit() {
        baiduMap = bmapView.getMap();
        bmapView.showScaleControl(false);
        bmapView.setEnabled(false);
        baiduMap = bmapView.getMap();
        LatLng cenpt =  new LatLng(38.048354,114.49578); // 默认中心坐标
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(cenpt,18.0f); // 经纬度，缩放比例
        baiduMap.setMapStatus(mapStatusUpdate);
    }
}
