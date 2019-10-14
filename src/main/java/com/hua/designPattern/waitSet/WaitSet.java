package com.hua.designPattern.waitSet;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/10/14 13:59
 */
public class WaitSet {
    private static final Object LOCK = new Object();

    /**
     * 1.所有的对象都有一个wait set，用来存放调用了该对象wait方法之后进入block状态线程；
     * 2.线程被notify之后，不一定立即被执行；
     * 3.线程从wait set中唤醒顺序不定；
     * 4.线程唤醒后，必须重新获取LOCK
     * @param args
     */
    public static void main(String[] args) {
        IntStream.rangeClosed(1,10)
                .forEach( n -> new Thread("thread" + String.valueOf(n)){
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            try {
                                Optional.of(Thread.currentThread().getName() + "==come to wait set").ifPresent(System.out::println);
                                LOCK.wait();
                                Optional.of(Thread.currentThread().getName() + "==leave to wait set").ifPresent(System.out::println);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }


                    }
                }.start());

        IntStream.rangeClosed(1,10).forEach(n -> {
            synchronized (LOCK) {
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
