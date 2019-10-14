package com.hua.designPattern.singleton;

/**
 * 单例模式（枚举）
 * @author huazai
 * @date 2019/10/14 13:52
 */
public enum SingletonEnum {
    /**
     * 枚举
     */
    INSTANCE;

    public SingletonEnum getInstance(){
        return INSTANCE;
    }
}
