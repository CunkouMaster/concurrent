package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/6 11:09
 */
public class FutureResult implements Result {

    private Result result;

    private boolean ready = false;

    public synchronized void setResult(Result result) {
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    @Override
    public Object getResultValue() {
        while (!ready) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultValue();
    }
}
