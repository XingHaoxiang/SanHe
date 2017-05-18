package com.zhuancheng.sanhedefence.presentation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.linearlistview.LinearListView;
import com.yanzhenjie.album.Album;
import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.http.api.GetEngPhotoDetailsClient;
import com.zhuancheng.sanhedefence.domain.http.api.QualityDetailClient;
import com.zhuancheng.sanhedefence.domain.http.response.PhotoDetailsAndList;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskDetailResponse;
import com.zhuancheng.sanhedefence.presentation.adapter.PhotoShowAdapter;
import com.zhuancheng.sanhedefence.presentation.weiget.ImageShow;
import com.zhuancheng.sanhedefence.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SiteQualityActivity extends BaseActivity{

    private static final int ACTIVITY_REQUEST_SELECT_PHOTO = 100;
    private static final int ACTIVITY_REQUEST_TAKE_PICTURE = 101;
    private static final int ACTIVITY_REQUEST_PREVIEW_PHOTO = 102;
    private static final String TAG = "SiteQualityActivity";
//    private GridView mSiteGv;
//    private GridViewAdapter mGridViewAdapter;
    private ArrayList<String> imgList; // 存放图片路径
    private ArrayList<String> imageDescription;

    /**下面变量基本再用*/
    private String[] titleString;
    private PhotoShowAdapter photoShowAdapter;
    private LinearListView vertical_list;
    private AppCompatEditText pjo_name,address,contact,phone,quality_task,yanshoubuwei;
    private QualityTaskDetailResponse taskDetailResponse;
    private String taskId;
    private AlertDialog alertDialog;
    private List<QualityTaskDetailResponse.EprIdListBean> eprIdListBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_site_quality);
        super.onCreate(savedInstanceState);
        setActionTitle("现场质监");
        initView();
        taskId = getIntent().getStringExtra("taskId");
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
//        mGridViewAdapter = new GridViewAdapter(imgList,imageDescription);
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

    /**
     * 这段代码暂时保留
     * @param requestCode
     * @param resultCode
     * @param data
     */
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
//        mGridViewAdapter.notifyDataSetChanged(imgList,imageDescription);
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



    private void getTaskDetails(final String taskID) {
        QualityDetailClient qualityDetailClient = new QualityDetailClient();
        qualityDetailClient.getQualityTaskDetail(taskID).enqueue(new Callback<QualityTaskDetailResponse>() {
            @Override
            public void onResponse(Call<QualityTaskDetailResponse> call, Response<QualityTaskDetailResponse> response) {
                taskDetailResponse = response.body();
                eprIdListBeen = taskDetailResponse.getEprIdList();
                pjo_name.setText(taskDetailResponse.getTaskName());
                address.setText(taskDetailResponse.getEngAddress());
                contact.setText(taskDetailResponse.getContactName());
                phone.setText(taskDetailResponse.getContactPhone()+"");
                yanshoubuwei.setText(eprIdListBeen.get(0).getPartName());
                titleString = new String[eprIdListBeen.size()];
                for (int i = 0; i < eprIdListBeen.size(); i++) {
                    titleString[i] = eprIdListBeen.get(i).getPartName();
                }

                // 加载数据完毕后默认添加第一项
                getPhotoList(taskID,eprIdListBeen.get(0).getParentId()+"",eprIdListBeen.get(0).getId()+"");
            }

            @Override
            public void onFailure(Call<QualityTaskDetailResponse> call, Throwable t) {
                ToastUtil.showToast("加载失败");
            }
        });

    }

    int clickItem = 0;
    public void taskList(View view) {

        alertDialog = new AlertDialog.Builder(this)
                .setTitle("请选择验收部位")
                .setSingleChoiceItems(titleString, clickItem, onClickListener)
                .create();

        alertDialog.show();


    }

    DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            yanshoubuwei.setText(titleString[which]);
            clickItem = which;
            QualityTaskDetailResponse.EprIdListBean eprIdListBean = eprIdListBeen.get(which);
            getPhotoList(taskId, eprIdListBean.getId()+"", eprIdListBean.getParentId()+"");
            alertDialog.dismiss();
        }
    };



    private void getPhotoList(String taskId,String psdId,String eprId) {
        GetEngPhotoDetailsClient client = new GetEngPhotoDetailsClient();
        client.getEngPhotoDetails(taskId, psdId, eprId).enqueue(new Callback<PhotoDetailsAndList>() {
            @Override
            public void onResponse(Call<PhotoDetailsAndList> call, Response<PhotoDetailsAndList> response) {
                List<PhotoDetailsAndList.ResultBean> result = response.body().getResult();
                photoShowAdapter = new PhotoShowAdapter(result,SiteQualityActivity.this);
                vertical_list.setAdapter(photoShowAdapter);
            }

            @Override
            public void onFailure(Call<PhotoDetailsAndList> call, Throwable t) {
                ToastUtil.showToast("网络出了故障，请选择部位重试");
            }
        });
    }
}
