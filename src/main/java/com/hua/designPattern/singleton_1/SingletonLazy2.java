package com.hua.designPattern.singleton_1;

/**
 * 懒汉模式
 * 缺点：串行化，影响性能
 * @author huazai
 * @date 2019/10/14 13:02
 */
public class SingletonLazy2 {

    private static SingletonLazy2 singletonLazy;

    private SingletonLazy2() {
    }

    public synchronized static SingletonLazy2 getInstance(){
        if(null == singletonLazy){
            singletonLazy = new SingletonLazy2();
        }
        return  singletonLazy;
    }
}
