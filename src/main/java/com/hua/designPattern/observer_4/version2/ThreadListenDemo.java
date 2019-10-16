package com.hua.designPattern.observer_4.version2;

import java.util.Arrays;

/**
 * @author huazai
 * @date 2019/10/16 15:28
 */
public class ThreadListenDemo {
    public static void main(String[] args) {
        new ThreadLifeCycle().concurrentQuery(Arrays.asList("1","2","3"));
    }
}
