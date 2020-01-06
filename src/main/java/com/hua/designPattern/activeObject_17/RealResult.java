package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/6 11:02
 */
public class RealResult implements Result {

    private final Object resultValue;

    public RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultValue() {
        return this.resultValue;
    }
}
