package com.hua.designPattern.future_8;

/**
 * @author huazai
 * @date 2019/10/18 13:21
 */
public interface FutureTask<T> {
    /**
     * 执行
     * @return
     */
    T call();

}
