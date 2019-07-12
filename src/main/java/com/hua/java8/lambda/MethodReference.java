package com.hua.java8.lambda;

import java.util.function.Consumer;

/**
 * @author huazai
 * @date 2019/7/12 15:12
 */
public class MethodReference {
    /**
     * lambda方法推导
     * @param args
     */
    public static void main(String[] args) {
        useConsumer(System.out::println ,"hello");
    }



    private static <T> void useConsumer(Consumer<T> consumer , T t){
        consumer.accept(t);
    }

}
