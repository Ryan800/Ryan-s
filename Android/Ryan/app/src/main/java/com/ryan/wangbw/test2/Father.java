package com.ryan.wangbw.test2;

/**
 * author: wangbw
 * Date: 2016-01-06
 * Time: 09:46
 * Desc:
 */
public abstract class Father {

    public int i=0;

    void doit() {
        System.out.println("father doit");
    }

    public void hehe() {
        doit();
    }
}
