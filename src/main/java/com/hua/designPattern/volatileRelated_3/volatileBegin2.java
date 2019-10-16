package com.hua.designPattern.volatileRelated_3;

/**
 * @author huazai
 * @date 2019/10/14 15:02
 */
public class volatileBegin2 {
    /**
     * 并未保证原子性
     */
    private volatile static int INIT_VALUE = 0;

    private final static int MAX_INIT = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            while (INIT_VALUE < MAX_INIT){
                System.out.println("T1--> " + (++INIT_VALUE));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ADD-1").start();

        new Thread(() -> {
            while (INIT_VALUE < MAX_INIT){
                System.out.println("T2--> " + (++INIT_VALUE));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ADD-2").start();
    }
}
