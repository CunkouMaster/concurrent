package com.hua.designPattern.observer_4;

/**
 * @author huazai
 * @date 2019/10/15 13:41
 */
public class BinaryObserver extends Observer {


    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String" + Integer.toBinaryString(subject.getState()));
    }
}
