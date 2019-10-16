package com.hua.designPattern.observer_4;

/**
 * @author huazai
 * @date 2019/10/15 14:39
 */
public class ObserverPatternDemo {

    public static void main(String[] args) {

        Subject subject = new Subject();

        new OctalObserver(subject);

        new BinaryObserver(subject);

        System.out.println("===================");

        subject.setState(10);

        System.out.println("===================");

        subject.setState(10);

        System.out.println("===================");

        subject.setState(100);
    }
}
