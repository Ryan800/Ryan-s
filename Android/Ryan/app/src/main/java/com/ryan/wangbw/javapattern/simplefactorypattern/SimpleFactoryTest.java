package com.ryan.wangbw.javapattern.simplefactorypattern;

/**
 * @author wangbw
 * @desc
 * @date 2015/10/29.
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Iphone iphone = IphoneFactory.createIphone("4s");
        iphone.sendMessage();
        iphone.call();

        iphone = IphoneFactory.createIphone("5s");
        iphone.surfTheInternet();
//        String aa = "sss";
//        WeakReference<String> weak = new WeakReference<String>(aa);
//        String bb = weak.get();
    }
}


