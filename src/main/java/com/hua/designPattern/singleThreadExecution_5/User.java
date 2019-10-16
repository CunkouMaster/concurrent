package com.hua.designPattern.singleThreadExecution_5;

/**
 * @author huazai
 * @date 2019/10/16 16:03
 */
public class User extends Thread{

    private String name;
    private String address;
    private  Gate gate;

    public User(String name, String address, Gate gate) {
        this.name = name;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println("=== BEGIN ===" + name);
        while (true) {
            gate.pass(name,address);
        }
    }
}
