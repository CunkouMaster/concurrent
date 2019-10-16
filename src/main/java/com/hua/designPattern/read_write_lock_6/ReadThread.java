package com.hua.designPattern.read_write_lock_6;

/**
 * @author huazai
 * @date 2019/10/16 17:18
 */
public class ReadThread extends Thread{

    private final ShareData data;

    public ReadThread(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] read = data.read();
                System.out.println("thread 【" + Thread.currentThread().getName() + "】 reads " + String.valueOf(read));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
