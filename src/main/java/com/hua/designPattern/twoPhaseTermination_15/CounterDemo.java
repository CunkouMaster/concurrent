package com.hua.designPattern.twoPhaseTermination_15;

/**
 * @author huazai
 * @date 2019/12/20 14:01
 */
public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement increment = new CounterIncrement();
        increment.start();

        Thread.sleep(500);
        increment.close();
    }
}
