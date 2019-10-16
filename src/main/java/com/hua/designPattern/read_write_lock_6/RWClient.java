package com.hua.designPattern.read_write_lock_6;

/**
 * @author huazai
 * @date 2019/10/16 17:21
 */
public class RWClient {
    public static void main(String[] args) {
        final ShareData data = new ShareData(10);

        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data,"abcdefg").start();
        new WriteThread(data,"1234567").start();
    }
}
