package com.ryan.wangbw.javapattern.simplefactorypattern;

/**
 * @author wangbw
 * @desc 工厂类
 * @date 2015/10/29.
 */
public final class IphoneFactory {

    /**
     * 创建产品
     * @param type
     * @return
     */
    public static Iphone createIphone(String type) {
        if (type == null) {
            return null;
        }
        Iphone iphone = null;
        if (type.equals("5s")) {
            iphone = new Iphone5s();
        } else {
            iphone = new Iphone4s();
        }
        return iphone;
    }
}
