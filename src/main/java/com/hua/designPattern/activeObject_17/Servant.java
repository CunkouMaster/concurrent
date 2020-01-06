package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/6 10:54
 */
public class Servant implements ActiveObject {

    @Override
    public Result makeString(int count, char fillChar) {
        char[] buf = new char[count];
        for(int i=0;i<count;i++){
            buf[i] = fillChar;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return new RealResult(new String(buf));
    }

    @Override
    public void displayString(String text) {
        System.out.println("display: " + text);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
