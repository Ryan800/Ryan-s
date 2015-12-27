package com.ryan.wangbw.mvp.biz;

/**
 * author: wangbw
 * Date: 2015-12-15
 * Time: 14:21
 * Desc:
 */
public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}
