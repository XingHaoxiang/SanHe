package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.Url;
import com.zhuancheng.sanhedefence.domain.http.response.PhotoDetailsAndList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cong on 2017/5/18.
 */

public class GetEngPhotoDetailsClient extends BaseClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Url.DOMAIN + Url.PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build();
    GetEngPhotoDetails getEngPhotoDetails = retrofit.create(GetEngPhotoDetails.class);
    public Call<PhotoDetailsAndList> getEngPhotoDetails(String taskId, String psdId, String eprId) {
        return getEngPhotoDetails.getEngPhotoDetails(taskId, psdId, eprId);
    }
}
