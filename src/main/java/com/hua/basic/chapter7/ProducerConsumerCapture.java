package com.hua.basic.chapter7;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author huazai
 * @date 2019/9/24 14:16
 */
public class ProducerConsumerCapture {

    private final static LinkedList<Object> CONTROLS = new LinkedList<>();
    private final static int MAX_WORKER = 5;

    private static Thread createCaptureThread(String name){
        //创建thread线程限制5个
        return new Thread(() -> {
            Optional.of("The worker 【" + Thread.currentThread().getName() + "】 begin capture data").ifPresent(System.out::println);
            synchronized (CONTROLS){
                while (CONTROLS.size() > MAX_WORKER){
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Object());
            }

            Optional.of("The worker 【" + Thread.currentThread().getName() + "】 is working ......").ifPresent(System.out::println);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (CONTROLS){
                Optional.of("The worker 【" + Thread.currentThread().getName() + "】 end capture data").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }


        },name);
    }

    public static void main(String[] args) {
        List<Thread> worker = new ArrayList<>();

        Stream.of("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10")
                .map(ProducerConsumerCapture::createCaptureThread)
                .forEach(thread -> {
                    thread.start();
                    worker.add(thread);
                });

        worker.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Optional.of("All of Capture work finished").ifPresent(System.out::println);
    }

}
