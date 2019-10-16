package com.hua.designPattern.read_write_lock_6;

/**
 * 读写锁
 * @author huazai
 * @date 2019/10/16 16:36
 */
public class ReadWriteLock {
    private int reading = 0;
    private int readWaiting = 0;
    private int writing = 0;
    private int writeWaiting = 0;

    private boolean preferWrite = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }

    public synchronized void readLock() throws InterruptedException {
        try {
            this.readWaiting++;
            while (writing > 0 || (preferWrite && writeWaiting > 0 )) {
                this.wait();
            }
            this.reading++;
        } finally {
            readWaiting--;
        }
    }

    public synchronized void readUnlock(){
        this.reading--;
        this.notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        this.writeWaiting++;
        try {
            while (reading > 0 || writing > 0){
                this.wait();
            }
            this.writing++;
        } finally {
            this.writeWaiting--;
        }
    }

    public synchronized void writeUnlock(){
        this.writing--;
        this.notifyAll();
    }


}
