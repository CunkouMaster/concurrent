package com.hua.java8.future;

import java.util.concurrent.*;

/**
 * @author huazai
 * @date 2019/8/26 13:12
 */
public class FutureInJdk {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            try {
                Thread.sleep(1000L);
                return "I am finished";
            } catch (InterruptedException e) {
                return "Error";
            }
        });

        while (future.isDone()){
            Thread.sleep(10);
        }

        String value = future.get();
        System.out.println(value);
        executorService.shutdown();
    }


}
