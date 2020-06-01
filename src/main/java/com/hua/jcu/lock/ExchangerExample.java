package com.hua.jcu.lock;

import java.util.concurrent.Exchanger;

/**
 * @author huazai
 * @date 2020/5/25 13:49
 */
public class ExchangerExample {

    public static void main(String[] args){

//        final Exchanger<String> exchanger = new Exchanger<>();
        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
//                System.out.println(Thread.currentThread().getName() + " start");
//                String result = exchanger.exchange("i am come from TA");
                Object a = new Object();
                System.out.println(Thread.currentThread().getName() + "set value 【" + a.hashCode() +"】");
                Object result = exchanger.exchange(a);
                System.out.println(Thread.currentThread().getName() + "get value 【" + result.hashCode() +"】");
//                System.out.println(Thread.currentThread().getName() + " END");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"==A==").start();

        new Thread(() -> {
            try {
//                System.out.println(Thread.currentThread().getName() + " start");
//                String result = exchanger.exchange("i am come from TB");
                Object b = new Object();
                System.out.println(Thread.currentThread().getName() + "set value 【" + b.hashCode() +"】");
                Object result = exchanger.exchange(b);
                System.out.println(Thread.currentThread().getName() + "get value 【" + result.hashCode() +"】");
//                System.out.println(Thread.currentThread().getName() + " END");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"==B==").start();

//        barrier.await();
//        System.out.println("all finish");
//        Thread.currentThread().join();

    }


}
