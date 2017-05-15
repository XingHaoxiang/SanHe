package com.zhuancheng.sanhedefence.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.http.api.QualityDetailClient;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskDetailResponse;
import com.zhuancheng.sanhedefence.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QualityDetail extends BaseActivity implements View.OnClickListener{
    private MapView bmapView;
    private BaiduMap baiduMap;
    private MapStatus mapStatus;
    private Button mButton;
    private TextView quality_detail_name,quality_detail_loc,quality_detail_contact,quality_detail_tel,
            quality_detail_demand,quality_detail_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_quality_detail);
        super.onCreate(savedInstanceState);
        setActionTitle("质监任务详情");
        String taskId = getIntent().getIntExtra("taskId", 0)+"";
//        baiduMapInit(0,0);
        initView();
        getTaskDetails(3+"");

    }

    private void initView() {
        bmapView = (MapView) findViewById(R.id.bmapView);
        mButton = (Button) findViewById(R.id.quality_detail_btn);
        mButton.setOnClickListener(this);
        quality_detail_name = (TextView) findViewById(R.id.quality_detail_name);
        quality_detail_loc = (TextView) findViewById(R.id.quality_detail_loc);
        quality_detail_contact = (TextView) findViewById(R.id.quality_detail_contact);
        quality_detail_tel = (TextView) findViewById(R.id.quality_detail_tel);
        quality_detail_demand = (TextView) findViewById(R.id.quality_detail_demand);
        quality_detail_time = (TextView) findViewById(R.id.quality_detail_time);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
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

    private void baiduMapInit(double lat,double lng) {
        baiduMap = bmapView.getMap();
        bmapView.showScaleControl(false);
        bmapView.setEnabled(false);
        baiduMap = bmapView.getMap();
        LatLng cenpt =  new LatLng(lat,lng); // 默认中心坐标
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLngZoom(cenpt,18.0f); // 经纬度，缩放比例
        baiduMap.setMapStatus(mapStatusUpdate);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SiteQualityActivity.class);
        startActivity(intent);
    }

    private void getTaskDetails(String taskID) {
        QualityDetailClient qualityDetailClient = new QualityDetailClient();
        qualityDetailClient.getQualityTaskDetail(taskID).enqueue(new Callback<QualityTaskDetailResponse>() {
            @Override
            public void onResponse(Call<QualityTaskDetailResponse> call, Response<QualityTaskDetailResponse> response) {
                QualityTaskDetailResponse detailResponse = response.body();
                quality_detail_name.setText(detailResponse.getTaskName());
                quality_detail_loc.setText(detailResponse.getEngAddress());
                quality_detail_contact.setText(detailResponse.getContactName());
//                quality_detail_tel.setText(detailResponse.getContactPhone());
                baiduMapInit(detailResponse.getLat(), detailResponse.getLng());

            }

            @Override
            public void onFailure(Call<QualityTaskDetailResponse> call, Throwable t) {
                ToastUtil.showToast("加载失败");
            }
        });

    }
}
