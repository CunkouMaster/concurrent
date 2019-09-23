package com.hua.basic.chapter7;

/**
 * @author huazai
 * @date 2019/9/23 17:03
 */
public class ProducerConsumerV1 {

    private int i = 1;

    private final Object LOCK = new Object();

    private void produce(){
        synchronized (LOCK) {
            System.out.println("producer -> " + (i++));
        }

    }

    private void consume(){
        synchronized (LOCK) {
            System.out.println("consumer -> " + i);
        }

    }

    public static void main(String[] args) {
        ProducerConsumerV1 v1 = new ProducerConsumerV1();

        new Thread("P"){
            @Override
            public void run() {
                while (true) {
                    v1.produce();
                }
            }
        }.start();

        new Thread("C"){
            @Override
            public void run() {
                while (true) {
                    v1.consume();
                }
            }
        }.start();
    }


}
