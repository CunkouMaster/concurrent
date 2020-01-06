package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/6 14:14
 */
public class SchedulerThread extends Thread{

    private final ActivationQueue activationQueue;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }

    @Override
    public void run() {
        while (true) {
            activationQueue.take().execute();
        }

    }

    public void invoke(MethodRequest request){
        this.activationQueue.put(request);
    }




}
