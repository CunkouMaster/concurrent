package com.hua.designPattern.producerConsumer_12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huazai
 * @date 2019/11/29 14:24
 */
public class Producer extends Thread{

    private final MessageQueue queue;

    private final static AtomicInteger counter = new AtomicInteger(0);

    public Producer(MessageQueue queue,int seq) {
        super("PRODUCER-" + seq);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message message = new Message("Message -- " + counter.getAndIncrement());
                queue.put(message);
                System.out.println(Thread.currentThread().getName() + " put message " + message.getData());
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
