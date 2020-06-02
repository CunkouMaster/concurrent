package com.hua.jcu.tool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author huanghaohua
 */
public class SemaphoreExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        //信号量，只允许 3个线程同时访问
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0;i < 5;i++){
            final long num = i;
            executorService.submit(() -> {
                try {
                    //获取许可
                    semaphore.acquire();
                    //执行
                    System.out.println("Accessing: " + num);
                    Thread.sleep(new Random().nextInt(5000)); // 模拟随机执行时长
                    //释放
                    semaphore.release();
                    System.out.println("Release..." + num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
    }

}