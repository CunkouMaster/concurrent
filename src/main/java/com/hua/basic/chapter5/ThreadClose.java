package com.hua.basic.chapter5;

/**
 * @author huazai
 * @date 2019/9/11 15:47
 */
public class ThreadClose {


    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();

    }



    public static class Worker extends Thread{
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start){
                //do something
            }
        }

        public void shutdown(){
            this.start = false;
        }
    }
}
