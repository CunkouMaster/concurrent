package com.hua.designPattern.read_write_lock_6;

import java.util.Random;

/**
 * @author huazai
 * @date 2019/10/16 17:12
 */
public class WriteThread extends Thread{
    private static final Random random = new Random(System.currentTimeMillis());

    private final ShareData data;

    private final String file;

    private int index = 0;

    public WriteThread(ShareData data, String file) {
        this.data = data;
        this.file = file;
    }

    @Override
    public void run() {

        try {
            while (true) {
                char text = nextChar();
                data.write(text);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private  char nextChar(){
        char c = file.charAt(index);
        index++;
        if(index >= file.length()){
            index = 0;
        }
        return c;
    }
}
