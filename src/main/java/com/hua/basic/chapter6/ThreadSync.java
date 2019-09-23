package com.hua.basic.chapter6;

/**
 * @author huazai
 * @date 2019/9/23 13:50
 */
public class ThreadSync {
    public static void main(String[] args) {
        final TicketRunnable ticketRunnable = new TicketRunnable();

        Thread tick1 = new Thread(ticketRunnable,"一号窗口");
        Thread tick2 = new Thread(ticketRunnable,"二号窗口");
        Thread tick3 = new Thread(ticketRunnable,"三号窗口");
        tick1.start();
        tick2.start();
        tick3.start();
    }
}

class TicketRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while ( true){
            //静态代码块
            synchronized (MONITOR){
                if(index > MAX){
                    break;
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "的号码是" + (index++));
            }

        }

    }
}