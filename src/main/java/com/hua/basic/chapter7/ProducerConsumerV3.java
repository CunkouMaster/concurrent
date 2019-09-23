package com.hua.basic.chapter7;

import java.util.stream.Stream;

/**
 * 多线程适用
 * @author huazai
 * @date 2019/9/23 17:03
 */
public class ProducerConsumerV3 {

    private int i = 1;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    private void produce(){
        synchronized (LOCK) {
            while (isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("producer -> " + i);
            LOCK.notifyAll();
            isProduced = true;

        }

    }

    private void consume(){
        synchronized (LOCK) {
            while (!isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("consumer -> " + i);
            LOCK.notifyAll();
            isProduced = false;

        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        ProducerConsumerV3 v3 = new ProducerConsumerV3();

        Stream.of("p1","p2","p3").forEach(n -> new Thread(n){
            @Override
            public void run() {
                while (true) {
                    v3.produce();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());

        Stream.of("C1","C2","C3").forEach(n -> new Thread(n){
            @Override
            public void run() {
                while (true) {
                    v3.consume();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start());


    }


}
