package com.hua.basic.chapter10;

import java.util.Arrays;

/**
 * @author huazai
 * @date 2019/10/8 10:38
 */
public class ThreadGroupCreate {
    public static void main(String[] args) {
        //use the name
        ThreadGroup group1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(group1,"t1"){
            @Override
            public void run() {
                while (true) {
                    System.out.println(getThreadGroup().getName());
                    System.out.println(getThreadGroup().getParent());
                    System.out.println(getThreadGroup().getParent().activeCount());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();

        //use the parent and group name
//        ThreadGroup group2 = new ThreadGroup(group1,"TG2");
//        System.out.println(group2.getName());
//        System.out.println(group2.getParent());

//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

        ThreadGroup group3 = new ThreadGroup("TG3");
        Thread t3 = new Thread(group3,"t3"){
            @Override
            public void run() {
                System.out.println(">>>" + group1.getName());
                Thread[] threads = new Thread[group1.activeCount()];
                group1.enumerate(threads);
                Arrays.asList(threads).forEach(System.out::println);
            }
        };

        t3.start();
    }
}
