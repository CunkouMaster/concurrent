package com.hua.designPattern.guradedSuspension_9;

/**
 * @author huazai
 * @date 2019/10/21 17:31
 */
public class SuspensionDemo {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();

        new ClientThread(queue,"Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();

        Thread.sleep(5000);
        serverThread.close();

    }
}
