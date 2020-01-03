package com.hua.designPattern.workerThread_16;

import java.util.Random;

/**
 * @author huazai
 * @date 2020/1/2 13:48
 */
public class TransportThread extends Thread {

    private final Channel channel;

    private static final Random random = new Random(System.currentTimeMillis());

    public TransportThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            //构造request,传送给传送带--put()
            for(int i=0 ; true ; i++){
                Request request = new Request(Thread.currentThread().getName(),i);
                this.channel.put(request);
                Thread.sleep(random.nextInt(1_000));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
