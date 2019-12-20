package com.hua.designPattern.threadPerMessage_14;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huazai
 * @date 2019/12/20 10:22
 */
public class MessageHandler {

    private final static Executor executor = Executors.newFixedThreadPool(5);

    public void request(Message message){
//        new Thread(() -> {
//            String value = message.getValue();
//            try {
//                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getName() + "======" + value);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//        }).start();

        executor.execute(() -> {
            String value = message.getValue();
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "======" + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    public void shutdown(){
        //ExecutorService extends Executor
        ((ExecutorService)executor).shutdown();
    }


}
