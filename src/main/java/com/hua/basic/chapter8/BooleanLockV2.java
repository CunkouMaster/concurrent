package com.hua.basic.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeoutException;

/**
 * 解决--线程wait后其他线程可以notify
 * @author huazai
 * @date 2019/9/24 16:08
 */
public class BooleanLockV2 implements Lock {

    /*
     * the initValue is false indicated the lock is free
     * the initValue is true indicated the lock have be get
     */
    private boolean initValue;

    private Collection<Thread> blockedThread = new ArrayList<>();

    private Thread currentThread;

    BooleanLockV2() {
        this.initValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue){
            blockedThread.add(Thread.currentThread());
            this.wait();
        }
        blockedThread.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeoutException {
        if(mills <= 0){
            lock();
        }
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if(hasRemaining <= 0){
                throw new TimeoutException("超时");
            }
            blockedThread.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = endTime - System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + " hasRemaining " + hasRemaining);
        }
        this.initValue = true;
        this.currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void unlock() {
        if(currentThread == Thread.currentThread()){
            this.initValue = false;
            System.out.println("【" + Thread.currentThread().getName() + "】 release the lock monitor");
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlocked() {
        return Collections.unmodifiableCollection(blockedThread);
    }

    @Override
    public int getBlockedSize() {
        return blockedThread.size();
    }
}
