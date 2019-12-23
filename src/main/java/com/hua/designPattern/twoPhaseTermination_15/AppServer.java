package com.hua.designPattern.twoPhaseTermination_15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huazai
 * @date 2019/12/20 14:45
 */
public class AppServer extends Thread{

    private final int port;

    private static final int DEFAULT_PORT = 12722;

    private volatile boolean start = true;

    private List<ClientHandler> clients = new ArrayList<>();

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    private ServerSocket server;

    public AppServer() {
        this(DEFAULT_PORT);
    }

    public AppServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            server = new ServerSocket(port);
            while (start) {
                Socket client = server.accept();
                ClientHandler handler = new ClientHandler(client);
                executor.submit(handler);
                clients.add(handler);
            }

        } catch (IOException e) {
//            throw new RuntimeException(e);
        } finally {
            dispose();
        }

    }

    public void shutdown() throws IOException {
        this.start = false;
        server.close();
        this.interrupt();
    }

    private void dispose(){
        System.out.println("主动 dispose");
        clients.stream().forEach(ClientHandler::stop);
        this.executor.shutdown();
    }
}
