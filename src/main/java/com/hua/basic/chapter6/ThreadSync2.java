package com.hua.basic.chapter6;

/**
 * @author huazai
 * @date 2019/9/23 13:50
 */
public class ThreadSync2 {
    public static void main(String[] args) {
        final TicketRunnable2 ticketRunnable = new TicketRunnable2();

        Thread tick1 = new Thread(ticketRunnable,"一号窗口");
        Thread tick2 = new Thread(ticketRunnable,"二号窗口");
        Thread tick3 = new Thread(ticketRunnable,"三号窗口");
        tick1.start();
        tick2.start();
        tick3.start();
    }
}

class TicketRunnable2 implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    @Override
    public void run() {
        while ( true){
            if(ticket()){
                break;
            }
        }

    }

    //同步方法
    private synchronized boolean ticket(){
        if(index > MAX){
            return true;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + "的号码是" + (index++));
        return false;
    }
}