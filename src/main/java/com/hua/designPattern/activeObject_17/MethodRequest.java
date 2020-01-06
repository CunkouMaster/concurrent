package com.hua.designPattern.activeObject_17;

/**
 * 对应activeObject的每一个方法
 * @author huazai
 * @date 2020/1/6 10:40
 */
public abstract class MethodRequest {

    protected final Servant servant;

    protected final FutureResult futureResult;

    public MethodRequest(Servant servant, FutureResult futureResult) {
        this.servant = servant;
        this.futureResult = futureResult;
    }

    public abstract void execute();
}
