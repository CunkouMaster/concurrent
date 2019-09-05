package com.hua.basic.chapter5;

/**
 * @author huazai
 * @date 2019/9/5 15:06
 */
public class ThreadJoinInAction {
    public static void main(String[] args) throws InterruptedException {
        /*
         * 模拟收集不同服务器数据
         */
        long startTime = System.currentTimeMillis();

        Thread t1 = new Thread(new CaptureRunnable("M1",1000));
        Thread t2 = new Thread(new CaptureRunnable("M2",2000));
        Thread t3 = new Thread(new CaptureRunnable("M3",3000));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTime = System.currentTimeMillis();
        System.out.println(String.format("数据收集完毕，用时%d" , (endTime - startTime)));
    }


}

class CaptureRunnable implements Runnable {

    private String machineName;

    private long spendTime;

    CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(machineName + " running complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult(){
        return machineName + "finish";
    }
}