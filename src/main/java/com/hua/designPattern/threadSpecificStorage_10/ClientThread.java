package com.hua.designPattern.threadSpecificStorage_10;

/**
 * @author huazai
 * @date 2019/11/11 14:21
 */
public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        Log.close();
        System.out.println(getName() + " END");
    }
}