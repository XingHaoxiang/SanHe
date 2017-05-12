package com.zhuancheng.sanhedefence.presentation.weiget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yanzhenjie.album.GalleryWrapper;
import com.yanzhenjie.album.adapter.BasicPreviewAdapter;
import com.yanzhenjie.album.adapter.PathPreviewAdapter;
import com.yanzhenjie.album.impl.GalleryCallback;
import com.yanzhenjie.fragment.NoFragment;
import com.zhuancheng.sanhedefence.R;

import java.util.List;

/**
 * Created by cong on 2017/5/11.
 */

public class ImageFragment extends NoFragment {
    private GalleryCallback mCallback;

    private int mToolBarColor;

    private MenuItem mFinishMenuItem;

    private View mCheckParent;

    private int mCurrentItemPosition;
    private ViewPager mViewPager;

    private List<String> mCheckedPaths;
    private List<String> mImageDes;
    private boolean[] mCheckedList;
    private TextView image_tv;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallback = (GalleryCallback) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mCallback = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.image_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mCheckParent = view.findViewById(R.id.layout_gallery_preview_bottom);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        image_tv = (TextView) view.findViewById(R.id.image_tv);

        setToolbar((Toolbar) view.findViewById(R.id.toolbar));
        displayHomeAsUpEnabled(R.drawable.album_ic_back_white);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle argument = getArguments();
        mToolBarColor = argument.getInt(
                GalleryWrapper.KEY_INPUT_TOOLBAR_COLOR,
                ContextCompat.getColor(getContext(), com.yanzhenjie.album.R.color.albumColorPrimary));

        // noinspection ConstantConditions
        getToolbar().setBackgroundColor(mToolBarColor);
        getToolbar().getBackground().mutate().setAlpha(200);

        this.mCurrentItemPosition = argument.getInt(GalleryWrapper.KEY_INPUT_CURRENT_POSITION, 0);
        if (mCurrentItemPosition >= mCheckedPaths.size()) mCurrentItemPosition = 0;

//        boolean hasCheck = argument.getBoolean(GalleryWrapper.KEY_INPUT_CHECK_FUNCTION, false);
//        if (!hasCheck) mCheckParent.setVisibility(View.GONE);

        initializeViewPager();

//        setCheckedCountUI(getCheckCount());
    }

    public void bindImagePaths(List<String> imagePaths) {
        this.mCheckedPaths = imagePaths;
        int length = mCheckedPaths.size();
        mCheckedList = new boolean[length];
        for (int i = 0; i < length; i++) {
            mCheckedList[i] = true;
        }
    }

    public void bindImageDes(List<String> mTitleName) {
        this.mImageDes = mTitleName;
//        int length = mImageDes.size();
    }

    private void initializeViewPager() {
        if (mCheckedPaths.size() > 2)
            mViewPager.setOffscreenPageLimit(2);

        BasicPreviewAdapter previewAdapter = new PathPreviewAdapter(mCheckedPaths);
        mViewPager.setAdapter(previewAdapter);
        ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mCurrentItemPosition = position;
                getToolbar().setTitle(mCurrentItemPosition + 1 + " / " + mCheckedPaths.size());
                image_tv.setText(mImageDes.get(position));
            }
        };
        mViewPager.addOnPageChangeListener(pageChangeListener);
        mViewPager.setCurrentItem(mCurrentItemPosition);
        // Forced call.
        pageChangeListener.onPageSelected(mCurrentItemPosition);
    }

    private void setCheckedCountUI(int count) {
        String finishStr = getString(R.string.album_menu_finish);
        finishStr += "(" + count + " / " + mCheckedPaths.size() + ")";
        mFinishMenuItem.setTitle(finishStr);
    }

    private int getCheckCount() {
        int i = 0;
        for (boolean b : mCheckedList) {
            if (b) i++;
        }
        return i;
    }


}
