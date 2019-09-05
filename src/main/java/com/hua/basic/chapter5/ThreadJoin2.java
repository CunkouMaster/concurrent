package com.hua.basic.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/7/12 10:21
 */
public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 is running");
            try {
                Thread.sleep(10_000);
                System.out.println("t1 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        //等待一段时间
        t1.join(100,10);
        //t1、t2输出完在输出main
        Optional.of("====== All of tasks finish ======").ifPresent(System.out::println);
        IntStream.range(1,1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "_index" + i));

//        Thread.currentThread().join();死循环，自身等待自身结束
    }
}
