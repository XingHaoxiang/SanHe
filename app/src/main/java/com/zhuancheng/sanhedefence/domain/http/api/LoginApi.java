package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.http.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by cong on 2017/5/15.
 */

public interface LoginApi {
    @GET("doLogin")
    Call<LoginResponse> doLogin(@Query("name") String name, @Query("pwd") String pwd);
}
