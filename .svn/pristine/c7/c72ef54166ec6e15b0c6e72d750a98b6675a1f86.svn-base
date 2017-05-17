package com.zhuancheng.sanhedefence.presentation.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.SpotCheckRecordBean;
import com.zhuancheng.sanhedefence.presentation.adapter.SpotCheckRecordAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cong on 2017/5/4.
 * 质监记录
 */
public class SpotCheckRecordFragment extends BaseFragment {
    private View mContent;
    private SpotCheckRecordAdapter spotCheckRecordAdapter;
    private List<SpotCheckRecordBean> spotCheckRecordBeen;
    private ListView mListView;

    public SpotCheckRecordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mContext = getActivity();
        mContent = inflater.inflate(R.layout.fragment_spot_check_record, container, false);
        initView();
        initData();
        return mContent;
    }

    private void initData() {
        spotCheckRecordBeen = new ArrayList<>();
        SpotCheckRecordBean spotCheckRecordBean1 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean2= new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean3 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean4 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean5 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean6 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean7 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        SpotCheckRecordBean spotCheckRecordBean8 = new SpotCheckRecordBean("123123-456-7890", "隐蔽工程预埋验收", "合格", "2017年5月6日19:51:26");
        spotCheckRecordBeen.add(spotCheckRecordBean1);
        spotCheckRecordBeen.add(spotCheckRecordBean2);
        spotCheckRecordBeen.add(spotCheckRecordBean3);
        spotCheckRecordBeen.add(spotCheckRecordBean4);
        spotCheckRecordBeen.add(spotCheckRecordBean5);
        spotCheckRecordBeen.add(spotCheckRecordBean6);
        spotCheckRecordBeen.add(spotCheckRecordBean7);
        spotCheckRecordBeen.add(spotCheckRecordBean8);
        spotCheckRecordAdapter = new SpotCheckRecordAdapter(spotCheckRecordBeen);
        mListView.setAdapter(spotCheckRecordAdapter);
    }

    private void initView() {
        mListView = (ListView) mContent.findViewById(R.id.fragment_record_lv);
    }

}
