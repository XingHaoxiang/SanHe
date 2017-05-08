package com.zhuancheng.sanhedefence.presentation.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.model.Site_QualityBean;
import com.zhuancheng.sanhedefence.presentation.adapter.SiteQualityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cong
 * 现场质监
 */
public class SiteQualityFragment extends BaseFragment {

    private String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494237780627&di=4cf6f4d8c3e8bed316e03f1b075cbb06&imgtype=0&src=http%3A%2F%2Fmvimg1.meitudata.com%2F56ce92d0b55ab9977.jpg";
    private String url2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494832540&di=5cb730a253ce83f30d11bcc42e7da491&imgtype=jpg&er=1&src=http%3A%2F%2Fmvimg1.meitudata.com%2F56dd26bf0cd151715.jpg";
    private String url3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494237840155&di=5c66b21b5dad10a3cb91da2bf39e366b&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201507%2F30%2F20150730163204_A24MX.thumb.700_0.jpeg";
    private String url4 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1494832572&di=4bcffca51fbb165a8a7ba2f0d50964c7&imgtype=jpg&er=1&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201404%2F02%2F20140402182945_Yyar4.thumb.700_0.jpeg";
    private View mContent;
    private ListView mSiteLv;
    private SiteQualityAdapter siteQualityAdapter;
    private List<Site_QualityBean> site_qualityBeen;
    public SiteQualityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContent = inflater.inflate(R.layout.fragment_site_quality, container, false);
        initView();
        initData();
        return mContent;
    }

    private void initView() {
        mSiteLv = (ListView) mContent.findViewById(R.id.site_lv);
    }

    private void initData() {
        site_qualityBeen = new ArrayList<>();
        Site_QualityBean site_qualityBean1 = new Site_QualityBean("主体结构验收1","君晓家园小区人防工程项目1",url1,url2,url3,url4,"2017年5月8日15:06:24");
        Site_QualityBean site_qualityBean2 = new Site_QualityBean("主体结构验收2","君晓家园小区人防工程项目2",url1,url2,url3,url4,"2017年5月8日15:06:24");
        Site_QualityBean site_qualityBean3 = new Site_QualityBean("主体结构验收3","君晓家园小区人防工程项目3",url1,url2,url3,url4,"2017年5月8日15:06:24");
        Site_QualityBean site_qualityBean4 = new Site_QualityBean("主体结构验收4","君晓家园小区人防工程项目4",url1,url2,url3,url4,"2017年5月8日15:06:24");
        site_qualityBeen.add(site_qualityBean1);
        site_qualityBeen.add(site_qualityBean2);
        site_qualityBeen.add(site_qualityBean3);
        site_qualityBeen.add(site_qualityBean4);
        siteQualityAdapter = new SiteQualityAdapter(site_qualityBeen);
        mSiteLv.setAdapter(siteQualityAdapter);
    }



}
