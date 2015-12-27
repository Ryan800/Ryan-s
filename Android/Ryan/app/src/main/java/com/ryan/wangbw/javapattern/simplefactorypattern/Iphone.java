package com.ryan.wangbw.javapattern.simplefactorypattern;

/**
 * @author wangbw
 * @desc Iphone穿品类，对应Product角色
 * @date 2015/10/29.
 */
public interface Iphone {
    /**
     * 打电话
     */
    void call();

    /**
     * 发短信
     */
    void sendMessage();

    /**
     * 上网
     */
    void surfTheInternet();
}
