package com.hua.designPattern.singleton;

/**
 * Holder模式
 * @author huazai
 * @date 2019/10/14 13:02
 */
public class SingletonHolder {

    private SingletonHolder() {
    }

    private static class InstanceHolder{
        private static SingletonHolder singletonHolder = new SingletonHolder();
    }

    public static SingletonHolder getInstance(){
        return  InstanceHolder.singletonHolder;
    }
}
