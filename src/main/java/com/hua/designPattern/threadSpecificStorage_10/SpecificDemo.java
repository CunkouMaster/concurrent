package com.hua.designPattern.threadSpecificStorage_10;

/**
 * @author huazai
 * @date 2019/11/11 14:22
 */
public class SpecificDemo {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }

}
