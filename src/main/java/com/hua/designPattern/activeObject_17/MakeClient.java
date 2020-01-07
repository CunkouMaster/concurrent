package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/7 10:26
 */
public class MakeClient extends Thread{

    private final ActiveObject activeObject;

    private final char fillChar;

    public MakeClient(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                Result result = activeObject.makeString(i + 1, fillChar);
                Thread.sleep(100);
                String value = String.valueOf(result.getResultValue());
                System.out.println(Thread.currentThread().getName() + "【value：" + value +"】" );

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
