package com.zhuancheng.sanhedefence.presentation.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.presentation.fragment.EngineeringDataFragment;
import com.zhuancheng.sanhedefence.presentation.fragment.QualityFragment;
import com.zhuancheng.sanhedefence.presentation.fragment.SiteQualityFragment;
import com.zhuancheng.sanhedefence.presentation.fragment.SpotCheckRecordFragment;

/**
 * Created by cong on 2017/5/4.
 */

public class MainActivity extends BaseActivity implements TabLayout.OnTabSelectedListener, DrawerLayout.DrawerListener {
    private TabLayout mTabLayout;
    private DrawerLayout activity_drawer;
    private FragmentManager fm;
    private QualityFragment mQualityFragment; // 质监任务
    private SiteQualityFragment mSiteQualityFragment; // 现场质监
    private SpotCheckRecordFragment mSpotCheckRecordFragment; // 抽查记录
    private EngineeringDataFragment mEngineeringDataFragment; // 工程资料
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setActionTitle(R.string.main_activity_title);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        activity_drawer = (DrawerLayout) findViewById(R.id.activity_drawer);
        activity_drawer.addDrawerListener(this);
        setLeftImage(R.drawable.nav_icon_list);
        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity_drawer.openDrawer(GravityCompat.START);
            }
        });
        setTab();
        mTabLayout.addOnTabSelectedListener(this);

        // 添加默认要显示的fragment
        mQualityFragment = new QualityFragment();
        fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, mQualityFragment);
        fragmentTransaction.commit();
    }

    private void setTab() {
        mTabLayout.addTab(mTabLayout.newTab().setText("质监任务")
                .setIcon(R.drawable.tb_icon_quality_supervision_task_pre));
        mTabLayout.addTab(mTabLayout.newTab().setText("现场质监").setIcon(R.drawable.tb_icon_site_quality_supervision));
        mTabLayout.addTab(mTabLayout.newTab().setText("抽查记录").setIcon(R.drawable.tb_icon_spot_record));
        mTabLayout.addTab(mTabLayout.newTab().setText("工程资料").setIcon(R.drawable.tb_icon_engineering_data));
    }



    private void selectTab(TabLayout.Tab tab, int position) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (position) {
            case 0:
                mTabLayout.getTabAt(0).setIcon(R.drawable.tb_icon_quality_supervision_task_pre);
                mTabLayout.getTabAt(1).setIcon(R.drawable.tb_icon_site_quality_supervision);
                mTabLayout.getTabAt(2).setIcon(R.drawable.tb_icon_spot_record);
                mTabLayout.getTabAt(3).setIcon(R.drawable.tb_icon_engineering_data);

                hideFragment(mSiteQualityFragment, fragmentTransaction);
                hideFragment(mSpotCheckRecordFragment, fragmentTransaction);
                hideFragment(mEngineeringDataFragment, fragmentTransaction);
                if (mQualityFragment == null) {
                    mQualityFragment = new QualityFragment();
                    fragmentTransaction.add(R.id.fragment_content, mQualityFragment);
                } else {
                    // 已经存在
                    fragmentTransaction.show(mQualityFragment);
                }
                break;
            case 1:
                mTabLayout.getTabAt(0).setIcon(R.drawable.tb_icon_quality_supervision_task);
                mTabLayout.getTabAt(1).setIcon(R.drawable.tb_icon_site_quality_supervision_pre);
                mTabLayout.getTabAt(2).setIcon(R.drawable.tb_icon_spot_record);
                mTabLayout.getTabAt(3).setIcon(R.drawable.tb_icon_engineering_data);

                hideFragment(mQualityFragment, fragmentTransaction);
                hideFragment(mSpotCheckRecordFragment, fragmentTransaction);
                hideFragment(mEngineeringDataFragment, fragmentTransaction);
                if (mSiteQualityFragment == null) {
                    mSiteQualityFragment = new SiteQualityFragment();
                    fragmentTransaction.add(R.id.fragment_content, mSiteQualityFragment);
                } else {
                    // 已经存在
                    fragmentTransaction.show(mSiteQualityFragment);
                }
                break;
            case 2:
                mTabLayout.getTabAt(0).setIcon(R.drawable.tb_icon_quality_supervision_task);
                mTabLayout.getTabAt(1).setIcon(R.drawable.tb_icon_site_quality_supervision);
                mTabLayout.getTabAt(2).setIcon(R.drawable.tb_icon_spot_record_pre);
                mTabLayout.getTabAt(3).setIcon(R.drawable.tb_icon_engineering_data);

                hideFragment(mQualityFragment, fragmentTransaction);
                hideFragment(mSiteQualityFragment, fragmentTransaction);
                hideFragment(mEngineeringDataFragment, fragmentTransaction);
                if (mSpotCheckRecordFragment == null) {
                    mSpotCheckRecordFragment = new SpotCheckRecordFragment();
                    fragmentTransaction.add(R.id.fragment_content, mSpotCheckRecordFragment);
                } else {
                    // 已经存在
                    fragmentTransaction.show(mSpotCheckRecordFragment);
                }
                break;
            case 3:
                mTabLayout.getTabAt(0).setIcon(R.drawable.tb_icon_quality_supervision_task);
                mTabLayout.getTabAt(1).setIcon(R.drawable.tb_icon_site_quality_supervision);
                mTabLayout.getTabAt(2).setIcon(R.drawable.tb_icon_spot_record);
                mTabLayout.getTabAt(3).setIcon(R.drawable.tb_icon_engineering_data_pre);

                hideFragment(mQualityFragment, fragmentTransaction);
                hideFragment(mSiteQualityFragment, fragmentTransaction);
                hideFragment(mSpotCheckRecordFragment, fragmentTransaction);
                if (mEngineeringDataFragment == null) {
                    mEngineeringDataFragment = new EngineeringDataFragment();
                    fragmentTransaction.add(R.id.fragment_content, mEngineeringDataFragment);
                } else {
                    // 已经存在
                    fragmentTransaction.show(mEngineeringDataFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    /**
     * 用来隐藏不显示的Fragment
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        Log.d(TAG, "onTabSelected: " + position);
        selectTab(tab, position);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
        Log.d(TAG, "onTabReselected: " + tab.getPosition());
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        View content = activity_drawer.getChildAt(0);
        View menu = drawerView;
        float scale =  slideOffset; // [1,0]
//        float contentScale = (float) (0.7f + 0.3 * scale);
        Log.d(TAG, "onDrawerSlide: " + scale);
        float menuscale = menu.getMeasuredWidth() * ( scale);
        Log.d(TAG, "menuscale: " + menuscale);
        content.setTranslationX(menuscale);
    }

    @Override
    public void onDrawerOpened(View drawerView) {

    }

    @Override
    public void onDrawerClosed(View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
