package com.hua.jcu.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author huazai
 * @date 2020/5/25 13:49
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("do some initial work");
            try {
                Thread.sleep(1000);
                latch.await();
                System.out.println("do other working");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("asyn prepare for some data");
            try {
                Thread.sleep(2000);
                System.out.println("data prepare done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();

        new Thread(() -> {
            try {
                latch.await();
                System.out.println("release");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        Thread.currentThread().join();

    }


}
