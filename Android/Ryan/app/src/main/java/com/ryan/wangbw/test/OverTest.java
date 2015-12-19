package com.ryan.wangbw.test;

import java.util.Random;

/**
 * @author wangbw
 * @desc
 * @date 2015/10/28.
 */
public class OverTest {
    public static void main(String[] args) {
//        OverTest test = new OverTest();
//        test.overLoad(null);

//        SubClass sc = new SubClass();
//        sc.printX();
        OverTest test = new OverTest();
        test.randInt(1,10);
    }

    private int randInt(int min, int max) {
        Random rand = new Random();
        int random = rand.nextInt(max -min +1) + min;
        System.out.println(random);
        return random;
    }

    private void overLoad(Object o) {
        System.out.println("Object");
    }

    private void overLoad(double[] array) {
        System.out.println("double array");
    }
}
