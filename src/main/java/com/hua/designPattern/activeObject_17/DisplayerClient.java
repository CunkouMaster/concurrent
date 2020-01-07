package com.hua.designPattern.activeObject_17;

/**
 * @author huazai
 * @date 2020/1/7 10:21
 */
public class DisplayerClient extends Thread{

    private final ActiveObject activeObject;

    public DisplayerClient(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                String text = Thread.currentThread().getName() + "###【" + i + "】";
                i++;
                activeObject.displayString(text);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
