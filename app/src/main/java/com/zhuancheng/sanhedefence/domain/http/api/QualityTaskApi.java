package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.http.response.QualityTaskResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cong on 2017/5/15.
 */

public interface QualityTaskApi {
    @GET("getAppTaskListByUserID")
    Call<QualityTaskResponse> taskList(@Query("userID") String userID
            ,@Query("taskStatus") String taskStatus);
}
