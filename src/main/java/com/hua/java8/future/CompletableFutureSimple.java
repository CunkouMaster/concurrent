package com.hua.java8.future;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

/**
 * @author huazai
 * @date 2019/8/26 14:26
 */
public class CompletableFutureSimple {

    private final static Random RANDOM = new Random(System.currentTimeMillis());

    public static void main(String[] args){
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            double value = get();
            completableFuture.complete(value);
        }).start();

        System.out.println("...no block....");

//        Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
        completableFuture.whenComplete((v,t) -> {
            Optional.ofNullable(v).ifPresent(System.out::println);
            Optional.ofNullable(t).ifPresent(Throwable::printStackTrace);
        });
    }

    static double get(){
        try {
            Thread.sleep(RANDOM.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return RANDOM.nextDouble();
    }
}
