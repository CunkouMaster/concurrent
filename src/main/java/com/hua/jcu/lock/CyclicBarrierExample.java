package com.hua.jcu.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author huazai
 * @date 2020/5/25 13:49
 */
public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        final CyclicBarrier barrier = new CyclicBarrier(2);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("T1 finish");
                barrier.await();
                System.out.println("T1 other finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("T2 finish");
                barrier.await();
                System.out.println("T2 other finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

//        Thread.currentThread().join();

    }


}
