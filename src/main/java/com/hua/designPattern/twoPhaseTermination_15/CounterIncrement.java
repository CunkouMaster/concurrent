package com.hua.designPattern.twoPhaseTermination_15;

/**
 * @author huazai
 * @date 2019/12/20 13:55
 */
public class CounterIncrement extends Thread{

    private volatile boolean terminated = false;

    private int counter = 0;

    @Override
    public void run() {

        try {
            while (!terminated){
                System.out.println(Thread.currentThread().getName() + "--" + (counter++) );
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    System.out.println("【线程sleep时被interrupt】" + e);
                }
            }
        } finally {
            this.clean();
        }


    }

    private void clean(){
        System.out.println("clean for the second Phase == counter【" + counter +"】");

    }

    public void close(){
        this.terminated = true;
        this.interrupt();
    }


}
