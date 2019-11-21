package com.hua.designPattern.balking_11;

/**
 * file改变时，change()和save()配套使用
 * @author huazai
 * @date 2019/11/21 13:37
 */
public class BalkingData {

    private final String fileName;

    private String content;

    private boolean changed;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save(){
        if(!changed){
            return;
        }

        doSave();
        this.changed = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName() + " do save,content " + this.content);
    }
}
