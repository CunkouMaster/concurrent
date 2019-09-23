package com.hua.basic.chapter6;

/**
 * @author huazai
 * @date 2019/9/23 15:26
 */
public class DeadLock {
    public static void main(String[] args) {
        OtherService other = new OtherService();
        DeadLockService deadLock = new DeadLockService(other);
        other.setDeadLockService(deadLock);
        new Thread("T1"){
            @Override
            public void run() {
                while (true){
                    deadLock.d1();
                }
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                while (true) {
                    other.o2();
                }
            }
        }.start();
    }

}

class OtherService{
    private final Object LOCK = new Object();

    private DeadLockService deadLockService;

    public void setDeadLockService(DeadLockService deadLockService) {
        this.deadLockService = deadLockService;
    }

    public void o1(){
        synchronized (LOCK) {
            System.out.println("====== o1 ======");
        }

    }

    public void o2(){
        synchronized (LOCK) {
            System.out.println("====== o2 ======");
            deadLockService.d2();
        }
    }

}

class DeadLockService{


    private OtherService otherService;

    private final Object LOCK = new Object();

    DeadLockService(OtherService otherService) {
        this.otherService = otherService;
    }

    public void d1(){
        synchronized (LOCK) {
            System.out.println("d1 ======");
            otherService.o1();
        }
    }

    public void d2(){
        synchronized (LOCK) {
            System.out.println("d2 ======");
        }

    }
}
