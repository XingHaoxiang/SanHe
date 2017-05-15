package com.zhuancheng.sanhedefence.presentation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.constants.Const;
import com.zhuancheng.sanhedefence.domain.http.api.QualityTaskClient;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskResponse;
import com.zhuancheng.sanhedefence.domain.model.QualityBean;
import com.zhuancheng.sanhedefence.presentation.activity.QualityDetail;
import com.zhuancheng.sanhedefence.presentation.adapter.QualityAdapter;
import com.zhuancheng.sanhedefence.utils.ShareData;
import com.zhuancheng.sanhedefence.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by cong on 2017/5/4.
 * 质监任务
 */
public class QualityFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    private static final String TAG = "QualityFragment";
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
        initData(ShareData.getShareIntData(Const.userId));
        return mContentView;
    }

    private void initView() {
        mQuality_ListView = (ListView) mContentView.findViewById(R.id.quality_lv);
        mQuality_ListView.setOnItemClickListener(this);
    }

    private void initData(int userId) {
        mQualityBeanList = new ArrayList<>();
        final QualityTaskClient qualityTaskClient = new QualityTaskClient();

        Call<QualityTaskResponse> qualityTaskResponseCall = qualityTaskClient.getTaskList(userId+"");
        qualityTaskResponseCall.enqueue(new Callback<QualityTaskResponse>() {
            @Override
            public void onResponse(Call<QualityTaskResponse> call, Response<QualityTaskResponse> response) {
                QualityTaskResponse qualityTaskResponse = new QualityTaskResponse();
                if (response.isSuccessful()) {
                    QualityBean qualityBean = new QualityBean(qualityTaskResponse.getId(),qualityTaskResponse.getTaskName(),
                            qualityTaskResponse.getEngName(),qualityTaskResponse.getEngAddress(),
                            qualityTaskResponse.getTaskDate());
                    mQualityBeanList.add(qualityBean);
                    mQuality_ListView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<QualityTaskResponse> call, Throwable t) {
                t.printStackTrace();
                ToastUtil.showToast("加载失败");
            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        QualityBean qualityBean = mQualityBeanList.get(position);
        Intent intent = new Intent(mContext, QualityDetail.class);
        intent.putExtra("taskId", qualityBean.getId());
        startActivity(intent);
    }

}
