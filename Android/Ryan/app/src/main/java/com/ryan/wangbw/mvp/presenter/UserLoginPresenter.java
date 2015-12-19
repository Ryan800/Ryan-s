package com.ryan.wangbw.mvp.presenter;

import android.os.Handler;

import com.ryan.wangbw.mvp.bean.User;
import com.ryan.wangbw.mvp.biz.IUserBiz;
import com.ryan.wangbw.mvp.biz.OnLoginListener;
import com.ryan.wangbw.mvp.biz.UserBiz;
import com.ryan.wangbw.mvp.view.IUserLoginView;
import com.socks.library.KLog;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 14:42
 * Desc:
 */
public class UserLoginPresenter implements OnLoginListener{
    private IUserBiz mIUserBiz;
    private IUserLoginView mIUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.mIUserLoginView = userLoginView;
        this.mIUserBiz = new UserBiz();
    }

    public void login(String name, String pwd) {
        mIUserLoginView.showLoading();
        mIUserBiz.login(name, pwd, this);
    }

    public void clear() {
        mIUserLoginView.clearUserName();
        mIUserLoginView.clearPassword();
    }

    @Override
    public void loginSuccess(User user) {
        KLog.i("UserLoginPresenter", Thread.currentThread().getName());
        mIUserLoginView.toMainActivity(user);
        mIUserLoginView.hideLoading();
    }

    @Override
    public void loginFailed() {
        mIUserLoginView.showFailedError();
        mIUserLoginView.hideLoading();
    }
}
