package com.hua.basic.chapter4;

/**
 * @author huazai
 * @date 2019/7/11 10:39
 */
public class CreateThread {
    public static void main(String[] args) {
        /*
         * 1、创建线程对象Thread，默认有一个线程名，以Thread-开头，从0开始计数
         * 构造函数Thread()
         * 2、如果构造Thread时没有传递Runnable或者没有重写run方法，该Thread将不会调用任何东西；如果有则调用
         */
        Thread t1 = new Thread();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("=========");
            }
        };
        t1.start();
        t2.start();
        System.out.println(t1.getName());
        System.out.println(t2.getName());


        /*
            构造线程时添加名称,Thread(String name)
         */
        Thread t3 = new Thread("MyThread");
        t3.start();
        System.out.println(t3.getName());

        /*
         构造函数 Thread(Runnable target, String name)
         */
        Thread t4 = new Thread(() -> {
            System.out.println("Is Run " + Thread.currentThread().getName());
        },"RunnableThread");
        t4.start();

    }

}
