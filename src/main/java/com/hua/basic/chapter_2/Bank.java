package com.hua.basic.chapter_2;

/**
 * @author huazai
 * @date 2019/7/3 16:20
 */
public class Bank {
    public static void main(String[] args) {
        /*
            第一版 继承Thread
         */
//        TicketThread t1 = new TicketThread("1号柜台");
//        TicketThread t2 = new TicketThread("2号柜台");
//        TicketThread t3 = new TicketThread("3号柜台");
//        t1.start();
//        t2.start();
//        t3.start();

        /*
            第二版 实现Runnable
         */
//        final TicketRunnable ticketRunnable = new TicketRunnable();
//        Thread tick1 = new Thread(ticketRunnable,"一号窗口");
//        Thread tick2 = new Thread(ticketRunnable,"二号窗口");
//        Thread tick3 = new Thread(ticketRunnable,"三号窗口");
//        tick1.start();
//        tick2.start();
//        tick3.start();

    }
}
