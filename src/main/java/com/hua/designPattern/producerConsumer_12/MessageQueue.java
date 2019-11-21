package com.hua.designPattern.producerConsumer_12;

import java.util.LinkedList;

/**
 * @author huazai
 * @date 2019/11/21 13:59
 */
public class MessageQueue {

    private final LinkedList<Message> queue;

    public MessageQueue(LinkedList<Message> queue) {
        this.queue = queue;
    }
}
