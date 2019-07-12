package com.hua.basic.chapter4;

import java.util.Optional;

/**
 * @author huazai
 * @date 2019/7/12 10:04
 */
public class ThreadSimpleApi {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1");
        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        //线程ID
        Optional.of(t.getId()).ifPresent(System.out::println);
        //优先级
        Optional.of(t.getPriority()).ifPresent(System.out::println);

    }
}
