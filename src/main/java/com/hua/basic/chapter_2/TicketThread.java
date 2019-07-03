package com.hua.basic.chapter_2;

/**
 * @author huazai
 * @date 2019/7/3 16:19
 */
public class TicketThread extends Thread {
    private final String name;
    private static final int MAX = 50;
    private static int index = 1;

    public TicketThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(name + "当前的号码是：" + (index++));
        }
    }

}
