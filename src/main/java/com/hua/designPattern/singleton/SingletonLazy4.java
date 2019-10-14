package com.hua.designPattern.singleton;

/**
 * 懒汉模式（double check + volatile）
 * @author huazai
 * @date 2019/10/14 13:02
 */
public class SingletonLazy4 {

    /*
     * volatile 特性：
     * 保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。（实现可见性）
     * 禁止进行指令重排序。（实现有序性）
     * 只能保证对单次读/写的原子性。i++ 这种操作不能保证原子性。
     */
    private static volatile SingletonLazy4 singletonLazy;

    private SingletonLazy4() {
    }

    public static SingletonLazy4 getInstance(){
        if(null == singletonLazy){
            synchronized (SingletonLazy4.class) {
                if(null == singletonLazy){
                    singletonLazy = new SingletonLazy4();

                }
            }
        }
        return  singletonLazy;
    }
}
