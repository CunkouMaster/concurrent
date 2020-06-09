package com.hua.jcu.lock;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huazai
 * @date 2020/6/9 14:07
 */
public class ConditionExample {

    private final static ReentrantLock LOCK = new ReentrantLock();

    private final static Condition PRODUCE_CONDITION = LOCK.newCondition();
    private final static Condition CONSUMER_CONDITION = LOCK.newCondition();

    private final static LinkedList<Long> TIMESTAMP_POOL = new LinkedList<>();
    private final static int MAX_CAPACITY = 100;



    private static void produce(){
        LOCK.lock();
        try {

            while (TIMESTAMP_POOL.size() >= MAX_CAPACITY){
                PRODUCE_CONDITION.await();
            }

            long time = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + "-P-" + time);
            TIMESTAMP_POOL.add(time);
            CONSUMER_CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }


    private static void consume(){
        LOCK.lock();
        try {

            while (TIMESTAMP_POOL.isEmpty()){
                CONSUMER_CONDITION.await();
            }
            Long time = TIMESTAMP_POOL.removeFirst();
            System.out.println(Thread.currentThread().getName() + "-C-" + time);
            PRODUCE_CONDITION.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {

    }

}
