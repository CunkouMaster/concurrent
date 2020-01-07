package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/7 10:33
 */
public class Test {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakeClient("AA",activeObject).start();
        new MakeClient("BB",activeObject).start();

        new DisplayerClient("QWER",activeObject).start();

    }
}
