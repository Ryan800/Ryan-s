package com.ryan.wangbw.test;

import java.util.concurrent.TimeUnit;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 16:08
 * Desc:
 */
public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) {
        Thread backgroupThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (!stopRequested) {
                    i++;
                    System.out.println("i:"+i);
                }
            }
        });
        backgroupThread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopRequested = true;
    }

}
