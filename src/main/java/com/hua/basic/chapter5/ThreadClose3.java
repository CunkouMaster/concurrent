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

        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();

        service.execute(() -> {
            //load a heavy resource
            while (true) {

            }
        });

        service.shutdown(10000);

        long end = System.currentTimeMillis();

        System.out.println(end - start);


    }

}

class ThreadService{

    private Thread excuteThread;

    private boolean finished = false;

    public void execute (Runnable task){
        excuteThread = new Thread(){
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

        excuteThread.start();
    }


    public void shutdown(long mills){
        long time = System.currentTimeMillis();
        while (!finished){
            if(System.currentTimeMillis() - time >= mills){
                System.out.println("任务超时！");
                excuteThread.interrupt();
                break;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }

        finished = false;
    }




}
