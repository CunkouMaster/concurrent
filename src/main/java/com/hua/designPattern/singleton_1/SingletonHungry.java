package com.hua.designPattern.singleton_1;

/**
 * 饿汉模式
 * 缺点：无法懒加载
 * @author huazai
 * @date 2019/10/14 13:02
 */
public class SingletonHungry {

    private static SingletonHungry singletonHungry = new SingletonHungry();

    private SingletonHungry() {
    }

    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}
