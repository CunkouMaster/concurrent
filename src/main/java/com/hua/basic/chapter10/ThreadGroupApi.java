package com.hua.basic.chapter10;

import java.util.Arrays;

/**
 * @author huazai
 * @date 2019/10/8 10:38
 */
public class ThreadGroupApi {
    public static void main(String[] args) {
        //use the name
        ThreadGroup group1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(group1,"t1"){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();

        ThreadGroup group2 = new ThreadGroup(group1,"TG2");
        Thread t2 = new Thread(group2,"t2"){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t2.start();

        System.out.println(group1.activeCount());
        System.out.println(group1.activeGroupCount());
        group2.checkAccess();
//        group1.destroy();

        System.out.println("===========================");

        Thread[] threads = new Thread[group1.activeCount()];
        group1.enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);

        System.out.println("===========================");
        group1.enumerate(threads,true);
        Arrays.asList(threads).forEach(System.out::println);

        System.out.println("===========================");
        threads = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(threads,true);
        Arrays.asList(threads).forEach(System.out::println);


        group1.interrupt();


    }
}
