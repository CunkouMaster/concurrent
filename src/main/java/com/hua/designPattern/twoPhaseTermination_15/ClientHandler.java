package com.hua.designPattern.twoPhaseTermination_15;

import java.io.*;
import java.net.Socket;

/**
 * 实现二阶段关闭
 * @author huazai
 * @date 2019/12/23 10:30
 */
public class ClientHandler implements Runnable{

    private final Socket socket;

    private volatile boolean running = true;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter pw = new PrintWriter(outputStream);
            while (running) {
                String message = br.readLine();
                if(message == null){
                    break;
                }
                System.out.println("come from client >>> " + message );
                pw.write("echo" + message + "\n");
                pw.flush();
            }
        } catch (IOException e) {
            this.running = false;
//            e.printStackTrace();
        } finally {
            stop();
        }

    }

    public void stop(){
        if(!running){
            return;
        }
        this.running = false;
        try {
            socket.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }
}
