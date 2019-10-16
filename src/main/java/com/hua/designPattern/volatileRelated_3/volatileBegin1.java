package com.hua.designPattern.volatileRelated_3;

/**
 * @author huazai
 * @date 2019/10/14 15:02
 */
public class volatileBegin1 {
    /**
     * (保证了不同线程间的可见性)
     * 不加volatile 关键字
     * read线程无法感知INIT_VALUE的变化，成为死循环
     */
    private volatile static int INIT_VALUE = 0;

    private final static int MAX_INIT = 5;

    public static void main(String[] args) {
        new Thread(()->{
            int local = INIT_VALUE;
            while (local < MAX_INIT) {
                if(local != INIT_VALUE){
                    System.out.printf("the value update to [%d]\n",INIT_VALUE);
                    local = INIT_VALUE;
                }
            }

        },"read").start();

        new Thread(() -> {
            int local = INIT_VALUE;
            while (INIT_VALUE < MAX_INIT){
                System.out.printf("update the value  to [%d]\n",++local);
                INIT_VALUE = local;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"update").start();
    }
}
