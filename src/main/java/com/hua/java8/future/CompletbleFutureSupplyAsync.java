package com.hua.java8.future;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author huazai
 * @date 2019/8/27 14:04
 */
public class CompletbleFutureSupplyAsync {

    public static void main(String[] args) throws InterruptedException {

        AtomicBoolean finished = new AtomicBoolean(false);

//        ExecutorService pool = Executors.newFixedThreadPool(2, thread -> {
//            Thread t = new Thread(thread);
//            //设置是否为守护进程
//            t.setDaemon(false);
//            return t;
//        });

        CompletableFuture.supplyAsync(CompletableFutureSimple::get)
                .whenComplete((v,t) -> {
                    Optional.ofNullable(v).ifPresent(System.out::println);
                    Optional.ofNullable(t).ifPresent(Throwable::printStackTrace);
                    finished.set(true);
        });

        System.out.println("...... no block ......");

//        Thread.currentThread().join();

        while (!finished.get()){
            Thread.sleep(10);
        }
    }

}
