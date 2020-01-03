package com.hua.designPattern.workerThread_16;

/**
 * @author huazai
 * @date 2020/1/3 13:47
 */
public class Client {
    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();

        new TransportThread("AA",channel).start();
        new TransportThread("BB",channel).start();
        new TransportThread("CC",channel).start();

    }

}
