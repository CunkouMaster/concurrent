package com.hua.designPattern.singleton;

/**
 * 懒汉模式
 * 缺点：多线程先可能不是单例
 * @author huazai
 * @date 2019/10/14 13:02
 */
public class SingletonLazy {

    private static SingletonLazy singletonLazy;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance(){
        if(null == singletonLazy){
            singletonLazy = new SingletonLazy();
        }
        return  singletonLazy;
    }
}
