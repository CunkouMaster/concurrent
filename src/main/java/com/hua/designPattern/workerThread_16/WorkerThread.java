package com.hua.designPattern.workerThread_16;

import java.util.Random;

/**
 * @author huazai
 * @date 2019/12/30 14:36
 */
public class WorkerThread extends Thread{

    private Channel channel;

    private static final Random random = new Random(System.currentTimeMillis());


    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            channel.get().execute();
            try {
                Thread.sleep(random.nextInt(1_1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
