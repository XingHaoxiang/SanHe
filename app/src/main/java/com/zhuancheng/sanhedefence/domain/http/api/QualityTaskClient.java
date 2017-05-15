package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.Url;
import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cong on 2017/5/15.
 */

public class QualityTaskClient extends BaseClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Url.DOMAIN + Url.PATH)
            .client(client())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    QualityTaskApi qualityTaskApi = retrofit.create(QualityTaskApi.class);

    public Call<QualityTaskResponse> getTaskList(String userId) {
        return qualityTaskApi.taskList(userId, "0");
    }

}
