package com.hua.designPattern.activeObject_17;

/**
 * 接受异步消息的主动方法
 * @author huazai
 * @date 2020/1/6 10:36
 */
public interface ActiveObject {

    Result makeString (int count ,char fillChar);

    void displayString (String text );
}
