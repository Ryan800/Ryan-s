package com.ryan.wangbw.mvp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ryan.wangbw.base.BaseAty;
import com.ryan.wangbw.mvp.bean.User;
import com.ryan.wangbw.mvp.presenter.UserLoginPresenter;
import com.ryan.wangbw.mvp.view.IUserLoginView;
import com.ryan.wangbw.mvp2.ui.activity.WeatherActivity;
import com.ryan.wangbw.myapplication.R;
import com.socks.library.KLog;

public class UserLoginActivity extends BaseAty implements IUserLoginView{

    private EditText mEtUserName, mEtPassword;
    private Button mBtnLogin, mBtnClear;
//    private ProgressBar mPbLoading;

    private ProgressDialog mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        KLog.i("UserLoginActivity", Thread.currentThread().getName());
        initViews();
    }

    private void initViews() {
        mEtUserName = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

//        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);
        mPbLoading = new ProgressDialog(this);
        mPbLoading.setTitle("Loading...");

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login(mEtUserName.getText().toString(), mEtPassword.getText().toString());
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();
            }
        });

    }

    @Override
    public void clearUserName() {
        mEtUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                mPbLoading.setVisibility(View.VISIBLE);
            }
        });
        mPbLoading.show();

    }

    @Override
    public void hideLoading() {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mPbLoading.setVisibility(View.GONE);
//            }
//        });
        KLog.i("UserLoginActivity#hideLoading()", Thread.currentThread().getName());
        mPbLoading.dismiss();

    }

    @Override
    public void toMainActivity(final User user) {
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
////                TShort(user.getUsername()+" login success, to MainActivity");
//
//            }
//        });
        KLog.i("UserLoginActivity#toMainActivity()", Thread.currentThread().getName());
        startActivity(new Intent(UserLoginActivity.this, WeatherActivity.class));

    }

    @Override
    public void showFailedError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TShort("login failed");
            }
        });

    }
}
