package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.Url;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskDetailResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cong on 2017/5/15.
 */

public class QualityDetailClient extends BaseClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Url.DOMAIN + Url.PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build();
    QualityTaskDetailApi detailApi = retrofit.create(QualityTaskDetailApi.class);

    public Call<QualityTaskDetailResponse> getQualityTaskDetail(String taskId) {
        return detailApi.getQualityDetail(taskId);
    }
}
