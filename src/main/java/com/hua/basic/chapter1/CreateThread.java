package com.hua.basic.chapter1;

/**
 * @author huazai
 * @date 2019/7/3 15:35
 */
public class CreateThread {


    public static void main(String[] args) {

        /*
         * 1、Java应用程序main函数是一个线程，是被JVM启动的时候调用，，线程名称叫main
         * 2、实现一个线程，必须创建thread实例，重写run方法，并调用start方法
         * 3、JVM启动后，实际上有多个线程，但至少有一个费守护线程
         * 4、调用一个线程的start方法的时候，此时至少有两个线程，一个调用你的线程，一个执行run方法的线程
         * 5、线程生命周期分为new runnable running block termated
         */
        new Thread("read-thread"){
            @Override
            public void run() {
                System.out.println("read线程启动");
                for(int i=0;i<10;i++){
                    System.out.println("read进行中" + i);
                }
                System.out.println("read线程结束");
            }
        }.start();

        new Thread("write-thread"){
            @Override
            public void run() {
                System.out.println("write线程启动");
                for(int i=0;i<10;i++){
                    System.out.println("write进行中" + i);
                }
                System.out.println("write线程结束");
            }
        }.start();

    }



}
