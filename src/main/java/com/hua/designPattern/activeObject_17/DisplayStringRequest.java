package com.hua.designPattern.activeObject_17;

/**
 * {@link ActiveObject#displayString(String)}
 * @author huazai
 * @date 2020/1/6 11:25
 */
public class DisplayStringRequest extends MethodRequest {

    private final String text;

    public DisplayStringRequest(Servant servant, String text) {
        super(servant, null);
        this.text = text;
    }

    @Override
    public void execute() {
        servant.displayString(text);

    }
}
