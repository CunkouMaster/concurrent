package com.hua.designPattern.observer_4;

/**
 * @author huazai
 * @date 2019/10/15 13:41
 */
public class OctalObserver extends Observer {


    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String" + Integer.toOctalString(subject.getState()));
    }
}
