package com.hua.basic.chapter6;

/**
 * @author huazai
 * @date 2019/9/23 15:04
 */
public class ThreadLockStatic {

    public static void main(String[] args) {
        new Thread("T1"){
            @Override
            public void run() {
                StaticLock.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                StaticLock.m2();
            }
        }.start();

        new Thread("T3"){
            @Override
            public void run() {
                StaticLock.m3();
            }
        }.start();

    }

}

class StaticLock{

    static {
        synchronized (StaticLock.class){
            System.out.println("static " + Thread.currentThread().getName());
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void m1(){
        System.out.println("m1 " + Thread.currentThread().getName());
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void m2(){
        System.out.println("m2 " + Thread.currentThread().getName());
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3(){
        System.out.println("m3 " + Thread.currentThread().getName());
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
