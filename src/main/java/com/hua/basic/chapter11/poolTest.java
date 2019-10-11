package com.hua.basic.chapter11;

/**
 * @author huazai
 * @date 2019/10/11 16:30
 */
public class poolTest {
    public static void main(String[] args) {
        testPool01();
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
