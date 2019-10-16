package com.hua.designPattern.observer_4;

/**
 * @author huazai
 * @date 2019/10/15 13:36
 */
public abstract class Observer {

    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public abstract void update();
}
