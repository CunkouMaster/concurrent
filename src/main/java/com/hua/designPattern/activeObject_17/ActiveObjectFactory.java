package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/6 15:04
 */
public final class ActiveObjectFactory {

    private ActiveObjectFactory() {
    }

    public static ActiveObject createActiveObject(){
        Servant servant = new Servant();
        ActivationQueue activationQueue = new ActivationQueue();
        SchedulerThread schedulerThread = new SchedulerThread(activationQueue);
        ActiveObjectProxy activeObjectProxy = new ActiveObjectProxy(schedulerThread,servant);
        schedulerThread.start();
        return activeObjectProxy;
    }
}
