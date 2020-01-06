package com.hua.designPattern.activeObject_17;

import java.util.LinkedList;

/**
 * @author huazai
 * @date 2020/1/6 13:22
 */
public class ActivationQueue {

    private final static int MAX_QUEUE_SIZE = 100;

    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        this.methodQueue = new LinkedList<>();
    }

    public synchronized void put(MethodRequest request){
        while (methodQueue.size() >= MAX_QUEUE_SIZE){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.methodQueue.addLast(request);
        this.notifyAll();

    }


    public synchronized MethodRequest take(){
        while (methodQueue.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        MethodRequest methodRequest = methodQueue.removeFirst();
        this.notifyAll();
        return methodRequest;
    }

}
