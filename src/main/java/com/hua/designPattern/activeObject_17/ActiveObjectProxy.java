package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/6 14:20
 */
public class ActiveObjectProxy implements ActiveObject{

    private final SchedulerThread schedulerThread;

    private final Servant servant;

    public ActiveObjectProxy(SchedulerThread schedulerThread, Servant servant) {
        this.schedulerThread = schedulerThread;
        this.servant = servant;
    }

    @Override
    public Result makeString(int count, char fillChar) {
        FutureResult futureResult = new FutureResult();
        schedulerThread.invoke(new MakeStringRequest(servant ,futureResult,count,fillChar));

        return futureResult;
    }

    @Override
    public void displayString(String text) {

        schedulerThread.invoke(new DisplayStringRequest(servant,text));

    }
}
