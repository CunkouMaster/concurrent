package com.hua.designPattern.twoPhaseTermination_15;

import java.io.IOException;

/**
 * @author huazai
 * @date 2019/12/23 10:48
 */
public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(13345);
        server.start();
        Thread.sleep(15_000L);
        server.shutdown();
    }
}
