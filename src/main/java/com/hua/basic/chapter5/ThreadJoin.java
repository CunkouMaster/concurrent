package com.hua.basic.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/7/12 10:21
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> IntStream.range(1,1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "_index" + i)));

        Thread t2 = new Thread(() -> IntStream.range(1,1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "_index" + i)));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Optional.of("All of tasks finish").ifPresent(System.out::println);
        IntStream.range(1,1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "_index" + i));
    }
}
