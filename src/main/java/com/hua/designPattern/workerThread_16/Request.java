package com.hua.designPattern.workerThread_16;

/**
 * @author huazai
 * @date 2019/12/30 14:34
 */
public class Request {
    private String name;

    private int num;

    public Request(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Request=> No【" + num + "】 Name【" + name + "】";
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() + " execute " + this);
    }


}
