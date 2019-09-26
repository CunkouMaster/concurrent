package com.hua.basic.chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeoutException;

/**
 * 缺陷线程wait后其他线程可以notify
 * @author huazai
 * @date 2019/9/24 16:08
 */
public class BooleanLockV1 implements Lock {

    /*
     * the initValue is false indicated the lock is free
     * the initValue is true indicated the lock have be get
     */
    private boolean initValue;

    private Collection<Thread> blockedThread = new ArrayList<>();

    public BooleanLockV1() {
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

    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {

    }

    @Override
    public synchronized void unlock() {
        this.initValue = false;
        System.out.println("【" + Thread.currentThread().getName() + "】 release the lock monitor");
        this.notifyAll();
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
