package com.hua.basic.chapter5;

/**
 * @author huazai
 * @date 2019/9/11 15:47
 */
public class ThreadClose3 {
    /**
     * 暴力结束线程
     * @param args
     */
    public static void main(String[] args) {


    }

}

class ThreadService{

    private Thread execteThread;

    private boolean finished = false;

    public void execute (Runnable task){
        execteThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);

                runner.start();

                try {
                    runner.join();
                    finished = true;
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }

            }
        };

        execteThread.start();
    }


    public void shutdown(long mills){

    }




}
