package com.zhuancheng.sanhedefence.presentation.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;

import com.zhuancheng.sanhedefence.R;
import com.zhuancheng.sanhedefence.domain.constants.Const;
import com.zhuancheng.sanhedefence.domain.http.api.LoginApiClient;
import com.zhuancheng.sanhedefence.domain.http.response.LoginResponse;
import com.zhuancheng.sanhedefence.utils.ShareData;
import com.zhuancheng.sanhedefence.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private AppCompatButton mLoginBtn;
    private ImageView mShowPwd;
    private AppCompatEditText mLoginUserName,mLoginPassword;
    private boolean isShowPwd = true;
    private static final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkVersion();
        initView();
    }

    private void checkVersion() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initView() {
        mLoginBtn = (AppCompatButton) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
        mShowPwd = (ImageView) findViewById(R.id.login_show_pwd);
        mShowPwd.setOnClickListener(this);
        mLoginUserName = (AppCompatEditText) findViewById(R.id.login_username);
        mLoginPassword = (AppCompatEditText) findViewById(R.id.login_password);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                String username = mLoginUserName.getText().toString();
                String password = mLoginPassword.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    ToastUtil.showToast(R.string.login_username_pwd_null);
                    return;
                }
                login(username, password);
                break;
            case R.id.login_show_pwd:
                if (isShowPwd) {
                    mLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    mShowPwd.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.login_icon_eyes_open));
                } else {
                    mLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    mShowPwd.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.login_icon_close_your_eyes));
                }
                isShowPwd = !isShowPwd;
                break;
        }
    }

    public void login(String name, String pwd) {
        final LoginApiClient loginApiClient = new LoginApiClient();
        Call<LoginResponse> loginResponseCall =  loginApiClient.doLogin(name, pwd);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (response.isSuccessful() && loginResponse.getCode() == 0) {
                    ToastUtil.showToast(loginResponse.getMessage());
                    ShareData.setShareIntData(Const.userId,loginResponse.getResult().getUserId());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    ToastUtil.showToast("登录失败");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                ToastUtil.showToast("登录失败，请重新登录");
            }
        });
    }
}
