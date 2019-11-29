package com.hua.designPattern.producerConsumer_12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huazai
 * @date 2019/11/29 14:24
 */
public class Consumer extends Thread {
    private final MessageQueue queue;

    public Consumer(MessageQueue queue, int seq) {
        super("COMSUMER-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = queue.take();
                System.out.println(Thread.currentThread().getName() + " take message " + message.getData());
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
