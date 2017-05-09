package com.zhuancheng.sanhedefence.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.yanzhenjie.album.Album;
import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.presentation.adapter.GridViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class SiteQualityActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private static final int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    private static final int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    private static final int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;
    private static final String TAG = "SiteQualityActivity";
    
    private GridView mSiteGv;
    private GridViewAdapter mGridViewAdapter;
    private ArrayList<String> imgList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_site_quality);
        super.onCreate(savedInstanceState);
        setActionTitle("现场质监");
        initView();
    }

    private void initView() {
        imgList = new ArrayList<>();
        mSiteGv = (GridView) findViewById(R.id.site_gv);
        mGridViewAdapter = new GridViewAdapter(imgList);
        mSiteGv.setAdapter(mGridViewAdapter);
        mSiteGv.setOnItemClickListener(this);
    }

    public void choose(){
        Log.d(TAG, "choose: in this");
        Album.album(this)
                .requestCode(ACTIVITY_REQUEST_SELECT_PHOTO)
                .title("图库")
                .selectCount(20).columnCount(4).camera(true).checkedList(imgList).start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ACTIVITY_REQUEST_SELECT_PHOTO: {
                if (resultCode == RESULT_OK) { // Successfully.
                    imgList = Album.parseResult(data); // Parse select result.
                    Log.d(TAG, "onActivityResult: " + imgList.size());
                    refreshImage();
                } else if (resultCode == RESULT_CANCELED) { // User canceled.
                    Toast.makeText(this, "取消操作", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case ACTIVITY_REQUEST_TAKE_PICTURE: {
                if (resultCode == RESULT_OK) { // Successfully.
                    List<String> imageList = Album.parseResult(data); // Parse path.
                    imgList.addAll(imageList);
                    refreshImage();
                } else if (resultCode == RESULT_CANCELED) { // User canceled.
                    Toast.makeText(this, "取消操作", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case ACTIVITY_REQUEST_PREVIEW_PHOTO: {
                if (resultCode == RESULT_OK) { // Successfully.
                    imgList = Album.parseResult(data); // Parse select result.
                    refreshImage();
                }
                break;
            }
        }
    }

    private void refreshImage() {
        mGridViewAdapter.notifyDataSetChanged(imgList);
    }

    private void previewImage(int position) {
        Album.gallery(this)
                .requestCode(ACTIVITY_REQUEST_PREVIEW_PHOTO)
                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary)) // Toolbar color.
                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark)) // StatusBar color.
                .navigationBarColor(ActivityCompat.getColor(this, R.color.albumColorPrimaryBlack)) // NavigationBar color.
                .checkedList(imgList) // Image list.
                .currentPosition(position) // Preview first to show the first few.
                .start();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == parent.getChildCount() - 1) {
            choose();
        } else {
            previewImage(position);
        }
    }
}
