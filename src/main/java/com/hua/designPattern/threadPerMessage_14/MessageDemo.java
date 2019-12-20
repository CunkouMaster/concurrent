package com.hua.designPattern.threadPerMessage_14;

import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/12/20 10:27
 */
public class MessageDemo {

    public static void main(String[] args) {
        MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(0,10).forEach(i -> handler.request(new Message("MESSAGE" + i)));
        handler.shutdown();
    }
}
