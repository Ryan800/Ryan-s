package com.ryan.wangbw.concurrent;

/**
 * author: wangbw
 * Date: 2015-12-01
 * Time: 16:57
 * Desc:
 */
public class NoVIsibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
