package com.hua.designPattern.countDown_13;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019-11-30 11:17
 */
public class JDKCountDown {
    /*
        并发执行，等所有线程执行完在进行接下来的任务
     */

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        System.out.println("######## 准备多线程处理任务 开始第一阶段########");
        //the first phase
        IntStream.rangeClosed(1,5).forEach(i -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is working");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            },String.valueOf(i)).start();
        });
        latch.await();
        //the second phase
        System.out.println("######## 多线程任务结束 准备第二阶段########");

        System.out.println("..................");

        System.out.println("######## 任务完成 ########");

    }

}
