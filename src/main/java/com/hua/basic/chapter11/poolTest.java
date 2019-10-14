package com.hua.basic.chapter11;

/**
 * @author huazai
 * @date 2019/10/11 16:30
 */
public class poolTest {
    public static void main(String[] args) throws InterruptedException {
//        testPool01();
//        testPool02();
        testPool03();

    }

    private static void testPool03() throws InterruptedException {
        SimpleThreadPool3 pool = new SimpleThreadPool3();
        for(int i = 0 ; i < 50; i++){
            int temp = i;
            pool.submit(() -> {
                System.out.println("runnable " + temp + " be serviced by " + Thread.currentThread() + "start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable " + temp + " be serviced by " + Thread.currentThread() + "finish");
            });

        }

        Thread.sleep(10000);
        pool.shutdown();
//        pool.submit(() -> System.out.println("=========="));
    }

    private static void testPool02() throws InterruptedException {
        SimpleThreadPool2 pool = new SimpleThreadPool2();
        for(int i = 0 ; i < 30; i++){
            int temp = i;
            pool.submit(() -> {
                System.out.println("runnable " + temp + " be serviced by " + Thread.currentThread() + "start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable " + temp + " be serviced by " + Thread.currentThread() + "finish");
            });

        }

        Thread.sleep(10000);
        pool.shutdown();
        pool.submit(() -> System.out.println("=========="));
    }


    private static void testPool01() {
        SimpleThreadPool pool = new SimpleThreadPool();
        for(int i = 0 ; i < 30; i++){
            int temp = i;
            pool.submit(() -> {
                System.out.println("runnable " + temp + " be serviced by " + Thread.currentThread() + "start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable " + temp + " be serviced by " + Thread.currentThread() + "finish");
            });

        }
    }
}
