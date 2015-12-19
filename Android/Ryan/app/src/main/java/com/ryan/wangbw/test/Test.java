package com.ryan.wangbw.test;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 16:06
 * Desc:
 */
public class Test {

    public static void main(String[] args) {
        one();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                one();
                two();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                one();
                two();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                one();
                two();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                one();
                two();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                one();
                two();
            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                one();
//                two();
//            }
//        }).start();

    }

    static int i=0, j=0;
    static void one() {
        i++;
        j++;
    }
    static void two() {
        System.out.println("i="+i+" j="+j);
    }
}
