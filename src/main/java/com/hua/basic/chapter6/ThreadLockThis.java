package com.hua.basic.chapter6;

/**
 * @author huazai
 * @date 2019/9/23 15:03
 */
public class ThreadLockThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("T1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();

        new Thread("T3"){
            @Override
            public void run() {
                thisLock.m3();
            }
        }.start();
    }
}

class ThisLock {
    private final Object LOCK = new Object();

    public synchronized  void m1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void m2(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void m3(){
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}