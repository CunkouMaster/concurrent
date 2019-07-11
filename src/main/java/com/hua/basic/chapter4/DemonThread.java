package com.hua.basic.chapter4;

/**
 * @author huazai
 * @date 2019/7/11 17:14
 */
public class DemonThread {
    public static void main(String[] args) {
        Thread outter = new Thread(() -> {
           Thread inner = new Thread(() -> {
               try {
                   while(true){
                       System.out.println("inner health check");
                       Thread.sleep(5*1000);
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           });
           //设为守护进程
           inner.setDaemon(true);
           inner.start();

            try {
                Thread.sleep(1000);
                System.out.println("outter finish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        outter.start();
    }
}
