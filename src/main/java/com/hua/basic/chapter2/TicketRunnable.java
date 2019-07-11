package com.hua.basic.chapter2;

/**
 * @author huazai
 * @date 2019/7/3 16:18
 */
public class TicketRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 50;

    @Override
    public void run() {
        while ( index <= MAX){
            System.out.println(Thread.currentThread() + "的号码是" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
