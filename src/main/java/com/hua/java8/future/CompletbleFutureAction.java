package com.hua.java8.future;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huazai
 * @date 2019/8/27 14:26
 */
public class CompletbleFutureAction {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2, thread -> {
            Thread t = new Thread(thread);
            //设置是否为守护进程
            t.setDaemon(false);
            return t;
        });

        CompletableFuture.supplyAsync(CompletableFutureSimple::get,pool)
                .thenApply(CompletbleFutureAction::multiply)
                .whenComplete((v,t) -> Optional.ofNullable(v).ifPresent(System.out::println));

    }

    private static double multiply(double value){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value * 10d;
    }
}
