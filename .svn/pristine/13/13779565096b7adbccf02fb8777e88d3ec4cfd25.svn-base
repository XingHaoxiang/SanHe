package com.zhuancheng.sanhedefence.domain.http.api;

import com.zhuancheng.sanhedefence.domain.Url;
import com.zhuancheng.sanhedefence.domain.http.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cong on 2017/5/15.
 */

public class LoginApiClient extends BaseClient{
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Url.DOMAIN + Url.PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client())
            .build();
    LoginApi loginApi = retrofit.create(LoginApi.class);
    public Call<LoginResponse> doLogin(String name, String pwd) {
        return loginApi.doLogin(name, pwd);
    }
}
