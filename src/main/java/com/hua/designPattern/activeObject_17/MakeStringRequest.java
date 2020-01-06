package com.hua.designPattern.activeObject_17;

/**
 * {@link ActiveObject#makeString(int, char)}
 * @author huazai
 * @date 2020/1/6 11:25
 */
public class MakeStringRequest extends MethodRequest {

    private final int count;
    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.count = count;
        this.fillChar = fillChar;
    }

    @Override
    public void execute() {

        Result result = servant.makeString(count, fillChar);
        futureResult.setResult(result);

    }
}
