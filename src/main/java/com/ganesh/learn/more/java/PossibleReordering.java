package com.ganesh.learn.more.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PossibleReordering {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            y = 1;
            x = 1;
            countDownLatch.countDown();
        });

        Thread two = new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = x;
            b = y;
        });

        two.start();
        one.start();

        one.join();
        two.join();

        System.out.println("x = " + x + " y = " + y);
        System.out.println("a = " + a + " b = " + b);
    }
}
