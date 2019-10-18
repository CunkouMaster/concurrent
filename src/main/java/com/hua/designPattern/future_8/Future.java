package com.hua.designPattern.future_8;

/**
 * @author huazai
 * @date 2019/10/18 13:21
 */
public interface Future<T> {
    /**
     * 获取值
     * @return
     */
    T get() throws InterruptedException;
}
