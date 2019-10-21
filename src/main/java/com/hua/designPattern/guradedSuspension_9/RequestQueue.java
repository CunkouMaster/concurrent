package com.hua.designPattern.guradedSuspension_9;

import java.util.LinkedList;

/**
 * @author huazai
 * @date 2019/10/21 15:45
 */
public class RequestQueue {

    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest(){
        synchronized (queue) {
            while (queue.size() <= 0){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    return null;
                }
            }

            return queue.removeFirst();
        }
    }


    public void putRequest(Request request){
        synchronized (queue) {
            queue.addLast(request);
            queue.notifyAll();
        }
    }


}
