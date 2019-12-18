package com.hua.designPattern.countDown_13;

/**
 * @author huazai
 * @date 2019/12/18 14:47
 */
public class SelfCountDown {

    private final int total;

    private int counter;

    public SelfCountDown(int total) {
        this.total = total;
    }

    public void down(){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (counter != total){
                this.wait();
            }
        }
    }
}
