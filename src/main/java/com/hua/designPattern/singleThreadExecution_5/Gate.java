package com.hua.designPattern.singleThreadExecution_5;

/**
 * 共享资源
 * @author huazai
 * @date 2019/10/16 15:56
 */
public class Gate {
    private int count = 0;
    private String name = "no one";
    private String address = "no address";

    /**
     * 多线程产生竞争，加this锁
     * @param name
     * @param address
     */
    public synchronized void pass (String name,String address){
        this.name = name;
        this.address = address;
        this.count++;
        //检查
        passVerify();
    }

    private void passVerify() {
        if(this.name.charAt(0) != this.address.charAt(0)){
            System.out.println("=== BROKEN ===【" + format() + "】");
        }

    }

    private String format() {
        return "No." + this.count + "-" + this.name + "-" + this.address;
    }

}
