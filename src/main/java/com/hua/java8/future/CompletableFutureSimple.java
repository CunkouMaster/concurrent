package com.hua.java8.future;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author huazai
 * @date 2019/8/26 14:26
 */
public class CompletableFutureSimple {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args){
        CompletableFuture completableFuture = new CompletableFuture();
        new Thread(() -> {
            double value = get();
            completableFuture.complete(value);
        }).start();

        System.out.println("...no block....");

//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
        completableFuture.whenComplete((v,t) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(System.out::println);
        });
    }

    private static double get(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return RANDOM.nextDouble();
    }
}
