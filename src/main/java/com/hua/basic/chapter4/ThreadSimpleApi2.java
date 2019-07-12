package com.hua.basic.chapter4;

import java.util.Optional;

/**
 * @author huazai
 * @date 2019/7/12 10:04
 */
public class ThreadSimpleApi2 {
    /**
     * 线程的优先级说明在程序中该线程的重要性。系统会根据优先级决定首先使用哪个线程，
     * 但这并不意味着优先级低的线程得不到运行，只是它运行的几率比较小而已
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                Optional.of(Thread.currentThread().getName() + "_index" + i).ifPresent(System.out::println);
            }
        });
        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                Optional.of(Thread.currentThread().getName() + "_index" + i).ifPresent(System.out::println);
            }
        });
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(() -> {
            for(int i=0;i<1000;i++){
                Optional.of(Thread.currentThread().getName() + "_index" + i).ifPresent(System.out::println);
            }
        });
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
