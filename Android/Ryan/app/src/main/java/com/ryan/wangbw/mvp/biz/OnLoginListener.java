package com.ryan.wangbw.mvp.biz;

import com.ryan.wangbw.mvp.bean.User;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 14:21
 * Desc:
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
