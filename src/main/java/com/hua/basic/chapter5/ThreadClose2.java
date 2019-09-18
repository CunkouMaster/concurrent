package com.hua.basic.chapter5;

/**
 * @author huazai
 * @date 2019/9/11 15:47
 */
public class ThreadClose2 {
    /**
     * 打断方式关闭线程
     * @param args
     */
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();

    }



    public static class Worker extends Thread{

        @Override
        public void run() {
            while (true){
                //do something
                if(Thread.interrupted()){
                    break;
                }
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    break;//return的话就无法执行后续逻辑
//                }
                //--- 后续逻辑 ----
            }
        }


    }
}
