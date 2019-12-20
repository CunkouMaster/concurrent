package com.hua.designPattern.threadPerMessage_14;

/**
 * @author huazai
 * @date 2019/12/20 10:20
 */
public class Message {

    private final String value;

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
