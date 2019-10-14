package com.hua.basic.chapter9;

/**
 * @author huazaiqd
 * @date 2019/10/2 15:23
 */
public class ThreadException {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10);
                int result = 10/0;
                System.out.println(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setUncaughtExceptionHandler((thread,throwable) -> {
            System.out.println(thread);
            System.out.println(throwable);
        });
        t.start();
    }
}
