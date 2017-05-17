package com.zhuancheng.sanhedefence.presentation.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.EngineerBean;
import com.zhuancheng.sanhedefence.presentation.activity.QualityDetail;
import com.zhuancheng.sanhedefence.presentation.adapter.EngineerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2017/5/4.
 * 工程资料
 */
public class EngineeringDataFragment extends BaseFragment {
    private View mContent;
    private EngineerAdapter engineerAdapter;
    private List<EngineerBean> engineerBeen;
    private ListView mList;
    public EngineeringDataFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        mContent = inflater.inflate(R.layout.fragment_engineering_data, container, false);
        initView();
        initData();
        return mContent;
    }

    private void initData() {
        engineerBeen = new ArrayList<>();
        engineerAdapter = new EngineerAdapter(engineerBeen);
        EngineerBean engineerBean1 = new EngineerBean("1","君晓家园小区人防工程","过程监督");
        EngineerBean engineerBean2 = new EngineerBean("2","兴业广场人防工程","工程交底");
        EngineerBean engineerBean3 = new EngineerBean("3","清欣园小区人防工程","过程监督");
        EngineerBean engineerBean4 = new EngineerBean("4","富华园小区人防工程","过程监督");
        EngineerBean engineerBean5 = new EngineerBean("5","联合国驻中国办事处人防工程","工程交底");
        EngineerBean engineerBean11 = new EngineerBean("6","君晓家园小区人防工程","过程监督");
        EngineerBean engineerBean21 = new EngineerBean("7","兴业广场人防工程","工程交底");
        EngineerBean engineerBean31 = new EngineerBean("8","清欣园小区人防工程","过程监督");
        EngineerBean engineerBean41 = new EngineerBean("9","富华园小区人防工程","过程监督");
        EngineerBean engineerBean51 = new EngineerBean("100","联合国驻中国办事处人防工程","工程交底");
        engineerBeen.add(engineerBean1);
        engineerBeen.add(engineerBean2);
        engineerBeen.add(engineerBean3);
        engineerBeen.add(engineerBean4);
        engineerBeen.add(engineerBean5);
        engineerBeen.add(engineerBean11);
        engineerBeen.add(engineerBean21);
        engineerBeen.add(engineerBean31);
        engineerBeen.add(engineerBean41);
        engineerBeen.add(engineerBean51);
        mList.setAdapter(engineerAdapter);

    }

    private void initView() {
        mList = (ListView) mContent.findViewById(R.id.engineer_lv);
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, QualityDetail.class);
                startActivity(intent);
            }
        });
    }


}
