package com.ryan.wangbw.mvp.view;

import com.ryan.wangbw.mvp.bean.User;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 14:24
 * Desc:
 */
public interface IUserLoginView {

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
