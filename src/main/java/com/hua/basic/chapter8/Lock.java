package com.hua.basic.chapter8;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

/**
 * @author huazai
 * @date 2019/9/24 16:03
 */
public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException,TimeoutException;

    void unlock();

    Collection<Thread> getBlocked();

    int getBlockedSize();


}
