package com.hua.basic.chapter4;

import java.util.Arrays;

/**
 * @author huazai
 * @date 2019/7/11 10:39
 */
public class CreateThread2 {
    public static void main(String[] args) {
        /*
            3、如果构造线程对象时未传入ThreadGroup，Thread会默认获取父线程的ThreadGroup作为自身的ThreadGroup
            此时子线程和父线程在同一个ThreadGroup
         */
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        //子线程ThreadGroup
        System.out.println(t.getThreadGroup().getName());
        //父线程
        System.out.println(Thread.currentThread().getName());
        //父线程ThreadGroup
        System.out.println(Thread.currentThread().getThreadGroup().getName());

        //线程数量
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        Thread [] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
//        for(Thread th :threads){
//            System.out.println(th.getName());
//        }
        Arrays.asList(threads).forEach(System.out::println);

        /*
            4、构造Thread时传入stacksize代表着该线程占用的stack的大小，如没有指定，默认是0,0代表忽略，改参数会被JNI函数使用
                改参数有些平台有效，有些平台无效
         */
    }

}
