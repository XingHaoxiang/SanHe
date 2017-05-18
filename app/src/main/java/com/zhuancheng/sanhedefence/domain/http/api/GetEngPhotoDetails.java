package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.http.response.PhotoDetailsAndList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cong on 2017/5/18.
 */

public interface GetEngPhotoDetails {
    @GET("getEngPhotoDetails")
    Call<PhotoDetailsAndList> getEngPhotoDetails(@Query("taskId") String taskId,
                                                 @Query("psdId") String psdId,
                                                 @Query("eprId") String eprId);
}
