package com.hua.designPattern.countDown_13;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/12/18 16:12
 */
public class SelfDemo {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final SelfCountDown latch = new SelfCountDown(5);
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
                latch.down();
            },String.valueOf(i)).start();
        });
        latch.await();
        //the second phase
        System.out.println("######## 多线程任务结束 准备第二阶段########");

        System.out.println("..................");

        System.out.println("######## 任务完成 ########");

    }

}
