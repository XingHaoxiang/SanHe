package com.zhuancheng.sanhedefence.presentation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.linearlistview.LinearListView;
import com.yanzhenjie.album.Album;
import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.http.api.QualityDetailClient;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskDetailResponse;
import com.zhuancheng.sanhedefence.presentation.adapter.GridViewAdapter;
import com.zhuancheng.sanhedefence.presentation.adapter.PhotoShowAdapter;
import com.zhuancheng.sanhedefence.presentation.weiget.ImageShow;
import com.zhuancheng.sanhedefence.presentation.weiget.MyGridView;
import com.zhuancheng.sanhedefence.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SiteQualityActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    private static final int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    private static final int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    private static final int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;
    private static final String TAG = "SiteQualityActivity";
    
//    private GridView mSiteGv;
    private GridViewAdapter mGridViewAdapter;
    private ArrayList<String> imgList; // 存放图片路径
    private ArrayList<String> imageDescription;
    private PhotoShowAdapter photoShowAdapter;
    private LinearListView vertical_list;
    private AppCompatEditText pjo_name,address,contact,phone,quality_task,yanshoubuwei;
    private QualityTaskDetailResponse taskDetailResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_site_quality);
        super.onCreate(savedInstanceState);
        setActionTitle("现场质监");
        initView();
        String taskId = getIntent().getStringExtra("taskId");
        getTaskDetails(taskId);
    }

    private void initView() {
        vertical_list = (LinearListView) findViewById(R.id.vertical_list);
        pjo_name = (AppCompatEditText) findViewById(R.id.pjo_name);
        address = (AppCompatEditText) findViewById(R.id.address);
        contact = (AppCompatEditText) findViewById(R.id.contact);
        phone = (AppCompatEditText) findViewById(R.id.phone);
        quality_task = (AppCompatEditText) findViewById(R.id.quality_task);
        yanshoubuwei = (AppCompatEditText) findViewById(R.id.yanshoubuwei);

        imgList = new ArrayList<>();
        imageDescription = new ArrayList<>();
//        mSiteGv = (GridView) findViewById(R.id.site_gv);
        mGridViewAdapter = new GridViewAdapter(imgList,imageDescription);
//        mSiteGv.setAdapter(mGridViewAdapter);
//        mSiteGv.setOnItemClickListener(this);
    }

    public void choose(){
        Log.d(TAG, "choose: in this");
        Album.album(this)
                .requestCode(ACTIVITY_REQUEST_SELECT_PHOTO)
                .title("图库")
                .selectCount(20).columnCount(4).camera(true).checkedList(imgList).start();
    }

    private void takePicture() {
        Album.camera(this)
                .requestCode(ACTIVITY_REQUEST_TAKE_PICTURE)
                .start();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ACTIVITY_REQUEST_SELECT_PHOTO: {
                // 从图库选择图片
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
                    final List<String> imageList = Album.parseResult(data); // Parse path.
//                    for (String s : imageList) {
//                        Log.d(TAG, "onActivityResult: " + s);
//                    }
                    final AppCompatEditText inputServer = new AppCompatEditText(this);
                    inputServer.setFocusable(true);
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("请输入图片名称");
                    builder.setMessage("输入图片名称后点击确定");
                    builder.setView(inputServer);
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showToast("取消保存图片");
                        }
                    });
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String inputName = inputServer.getText().toString();
                            imageDescription.add(inputName);
                            imgList.addAll(imageList);
                            refreshImage();
                        }
                    });
                    builder.show();

                } else if (resultCode == RESULT_CANCELED) { // User canceled.
                    Toast.makeText(this, "取消操作", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case ACTIVITY_REQUEST_PREVIEW_PHOTO: {
                if (resultCode == RESULT_OK) { // Successfully.
//                    imgList = Album.parseResult(data); // Parse select result.
//                    refreshImage();
                }
                break;
            }
        }
    }

    private void refreshImage() {
        mGridViewAdapter.notifyDataSetChanged(imgList,imageDescription);
    }

    private void previewImage(ArrayList<String> imgList) {

        ImageShow.gallery(this)
                .requestCode(ACTIVITY_REQUEST_PREVIEW_PHOTO)
                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary)) // Toolbar color
                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark)) // StatusB
                .navigationBarColor(ActivityCompat.getColor(this, R.color.albumColorPrimaryBlack))
                .checkedList(imgList)
                .titleList(imageDescription)
                .start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == parent.getChildCount() - 1) {
            takePicture();
        } else {
//            previewImage(position);
        }
    }

    private void getTaskDetails(String taskID) {
        QualityDetailClient qualityDetailClient = new QualityDetailClient();
        qualityDetailClient.getQualityTaskDetail(taskID).enqueue(new Callback<QualityTaskDetailResponse>() {
            @Override
            public void onResponse(Call<QualityTaskDetailResponse> call, Response<QualityTaskDetailResponse> response) {
                taskDetailResponse = response.body();
                List<QualityTaskDetailResponse.EprIdListBean> eprIdListBeen = taskDetailResponse.getEprIdList();
                pjo_name.setText(taskDetailResponse.getTaskName());
                address.setText(taskDetailResponse.getEngAddress());
                contact.setText(taskDetailResponse.getContactName());
                phone.setText(taskDetailResponse.getContactPhone()+"");
                yanshoubuwei.setText(eprIdListBeen.get(0).getPartName());
                photoShowAdapter = new PhotoShowAdapter(eprIdListBeen,SiteQualityActivity.this);
                vertical_list.setAdapter(photoShowAdapter);
            }

            @Override
            public void onFailure(Call<QualityTaskDetailResponse> call, Throwable t) {
                ToastUtil.showToast("加载失败");
            }
        });

    }

    public View addView(ViewGroup parent, final QualityTaskDetailResponse.EprIdListBean eprIdListBean) {
        View view = LayoutInflater.from(this).inflate(R.layout.photo_add, parent,false);
        final TextView buwei = (TextView) view.findViewById(R.id.buwei);
        buwei.setText(eprIdListBean.getPartName());
        TextView yaoqiu = (TextView) view.findViewById(R.id.yaoqiu);
        MyGridView photo_gv = (MyGridView) view.findViewById(R.id.photo_gv);
        final ArrayList<String> imgList = new ArrayList<>();
        GridViewAdapter gridViewAdapter = new GridViewAdapter(imgList);
        photo_gv.setAdapter(gridViewAdapter);
//        photo_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == parent.getChildCount() - 1) {
//                    takePicture();
//                } else {
//                    previewImage(imgList);
//                }
//            }
//        });
        yaoqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(buwei.getText().toString());
                Intent intent = new Intent(SiteQualityActivity.this, PhotoRequire.class);
                intent.putExtra("partName", eprIdListBean.getPartName());
            }
        });
        return view;
    }

    public void taskList(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("请选择验收部位")
//                .setSingleChoiceItems()
                .create();

        alertDialog.show();

    }
}
