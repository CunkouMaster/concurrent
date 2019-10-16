package com.hua.designPattern.singleton_1;

/**
 * 懒汉模式（double check）
 * 缺点：可能会引发空指针异常
 * @author huazai
 * @date 2019/10/14 13:02
 */
public class SingletonLazy3 {

    private static SingletonLazy3 singletonLazy;

    private SingletonLazy3() {
    }

    public static SingletonLazy3 getInstance(){
        if(null == singletonLazy){
            synchronized (SingletonLazy3.class) {
                if(null == singletonLazy){
                    singletonLazy = new SingletonLazy3();

                }
            }
        }
        return  singletonLazy;
    }
}
