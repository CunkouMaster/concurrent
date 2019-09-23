package com.hua.basic.chapter7;

/**
 * 适用于单线程
 * @author huazai
 * @date 2019/9/23 17:03
 */
public class ProducerConsumerV2 {

    private int i = 1;

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    private void produce(){
        synchronized (LOCK) {
            if(isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                i++;
                System.out.println("producer -> " + i);
                LOCK.notify();
                isProduced = true;
            }
        }

    }

    private void consume(){
        synchronized (LOCK) {
            if(isProduced){
                System.out.println("consumer -> " + i);
                LOCK.notify();
                isProduced = false;
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 多个producer 和 多个consumer 存在问题（notify的线程不能明确，造成死锁）
     * @param args
     */
    public static void main(String[] args) {
        ProducerConsumerV2 v2 = new ProducerConsumerV2();

        new Thread("P"){
            @Override
            public void run() {
                while (true) {
                    v2.produce();
                }
            }
        }.start();

        new Thread("C"){
            @Override
            public void run() {
                while (true) {
                    v2.consume();
                }
            }
        }.start();
    }


}
