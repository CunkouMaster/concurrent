package com.hua.designPattern.producerConsumer_12;

/**
 * @author huazai
 * @date 2019/11/29 14:36
 */
public class Client {
    public static void main(String[] args) {
        final MessageQueue queue = new MessageQueue();

        new Producer(queue,1).start();
        new Producer(queue,2).start();
        new Producer(queue,3).start();
        new Consumer(queue,1).start();
        new Consumer(queue,2).start();
    }
}
