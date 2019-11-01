package com.hua.designPattern.threadSpecificStorage_10;

/**
 * @author huazai
 * @date 2019/11/1 14:21
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            local.set("Thread-T1");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "==" + local.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "T1");
        t1.start();

        Thread t2 = new Thread(() -> {
            local.set("Thread-T2");
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "==" + local.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "T2");
        t2.start();

        t1.join();
        t2.join();


        System.out.println(Thread.currentThread().getName() + "==" + local.get());


    }


}
