package com.ryan.wangbw.test;

import java.util.Iterator;
import java.util.Map;

/**
 * @author wangbw
 * @desc
 * @date 2015/10/28.
 */
public class SubClass extends SuperClass{
    private int mSubX ;
    public SubClass(){}

    @Override
    public void setX(int x) {
        super.setX(x);
        mSubX = x;
        System.out.println("SubX is assigned "+x);
    }

    public void printX() {
        System.out.println("SubX = " + mSubX);
        int i = 8;
        long j = 19;
        i += j;
    }

    private void printMap(Map mp) {
        Iterator it = mp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println("key:"+pair.getKey()+"value:"+pair.getValue());
            it.remove();
        }
    }



}
