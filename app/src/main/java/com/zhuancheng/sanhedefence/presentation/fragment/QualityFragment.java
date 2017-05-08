package com.zhuancheng.sanhedefence.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.QualityBean;
import com.zhuancheng.sanhedefence.presentation.activity.QualityDetail;
import com.zhuancheng.sanhedefence.presentation.adapter.QualityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2017/5/4.
 * 质监任务
 */
public class QualityFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    private View mContentView;
    private ListView mQuality_ListView;
    private QualityAdapter mAdapter;
    private List<QualityBean> mQualityBeanList;
    public QualityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContentView = inflater.inflate(R.layout.fragment_quality, container, false);
        mContext = getActivity();
        initView();
        initData();
        return mContentView;
    }

    private void initView() {
        mQuality_ListView = (ListView) mContentView.findViewById(R.id.quality_lv);
        mQuality_ListView.setOnItemClickListener(this);
    }

    private void initData() {
        mQualityBeanList = new ArrayList<>();
        QualityBean qualityBean = new QualityBean("主体结构验收","君晓家园小区人防工程项目","和平西路与鼎盛西大街交叉口南行300米路东","2017年5月6日18:38:52");
        QualityBean qualityBean1 = new QualityBean("主体结构验收","君晓家园小区人防工程项目","和平西路与鼎盛西大街交叉口南行300米路东","2017年5月6日18:38:52");
        QualityBean qualityBean2 = new QualityBean("主体结构验收","君晓家园小区人防工程项目","和平西路与鼎盛西大街交叉口南行300米路东","2017年5月6日18:38:52");
        QualityBean qualityBean3 = new QualityBean("主体结构验收","君晓家园小区人防工程项目","和平西路与鼎盛西大街交叉口南行300米路东","2017年5月6日18:38:52");
        QualityBean qualityBean12 = new QualityBean("主体结构验收","君晓家园小区人防工程项目","和平西路与鼎盛西大街交叉口南行300米路东","2017年5月6日18:38:52");
        QualityBean qualityBean13 = new QualityBean("主体结构验收","君晓家园小区人防工程项目","和平西路与鼎盛西大街交叉口南行300米路东","2017年5月6日18:38:52");
        mQualityBeanList.add(qualityBean);
        mQualityBeanList.add(qualityBean1);
        mQualityBeanList.add(qualityBean2);
        mQualityBeanList.add(qualityBean3);
        mQualityBeanList.add(qualityBean12);
        mQualityBeanList.add(qualityBean13);
        mAdapter = new QualityAdapter(mQualityBeanList);
        mQuality_ListView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mContext, QualityDetail.class);
        startActivity(intent);
    }
}
