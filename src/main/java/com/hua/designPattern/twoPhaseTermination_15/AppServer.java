package com.hua.designPattern.twoPhaseTermination_15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huazai
 * @date 2019/12/20 14:45
 */
public class AppServer extends Thread{

    private final int port;

    private static final int DEFAULT_PORT = 12722;

    private volatile boolean start = true;

    private List<Thread> clientHandler = new ArrayList<>();

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port);
            while (start) {
                Socket socket = server.accept();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void shutdown(){
        this.start = false;
    }
}
