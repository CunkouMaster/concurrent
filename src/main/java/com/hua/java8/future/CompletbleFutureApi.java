package com.hua.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @date 2019/8/27 16:27
 */
public class CompletbleFutureApi {
    public static void main(String[] args) throws InterruptedException {
        /*
         * supplyAsync
         * thenApply
         * whenComplete
         * handle
         * thenAccept
         * thenCompose
         * thenCombine
         * thenAcceptBoth
         */
        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> Integer.sum(i,10))
                .whenComplete((v,t) -> Optional.ofNullable(v).ifPresent(System.out::println));
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> 1)
                .handle((v,t) -> Integer.sum(v,10))
                .whenComplete((v,t) -> Optional.ofNullable(v).ifPresent(System.out::println));
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> 1)
                .thenApply(i -> Integer.sum(i,10))
                .thenAccept(System.out::println);
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> 1)
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> i*10))
                .thenAccept(System.out::println);
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> 1)
                .thenCombine(CompletableFuture.supplyAsync(() -> 0.2d),(r1,r2) -> r1 + r2)
                .thenAccept(System.out::println);
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> 1)
                .thenAcceptBoth(CompletableFuture.supplyAsync(() -> 0.2d),(r1,r2) -> {
                    System.out.println(r1);
                    System.out.println(r2);
                    System.out.println(r1+r2);
                });

        /*
         * runAfterBoth
         * applyToEither
         * acceptEither
         * runAfterEither
         */
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "A is running");
            return 1;
        }).runAfterBoth(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "B is running");
            return 2;
        }),() -> System.out.println("both done"));
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("future 1");
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("future 2");
            return 2;
        }),v -> v*10).thenAccept(System.out::println);
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("future 1");
            return 1;
        }).acceptEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("future 2");
            return 2;
        }),System.out::println);
        System.out.println("==========");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("future 1");
            return 1;
        }).runAfterEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("future 2");
            return 2;
        }),() -> System.out.println("runAfterEither done"));
        System.out.println("==========");

        List<CompletableFuture<Double>> result = Arrays.asList(1, 2, 3, 4, 5).stream()
                .map(i -> CompletableFuture.supplyAsync(CompletableFutureSimple::get))
                .collect(Collectors.toList());

        CompletableFuture.allOf(result.toArray(new CompletableFuture[result.size()]))
                .thenRun(() -> System.out.println("allOf done"));

        CompletableFuture.anyOf(result.toArray(new CompletableFuture[result.size()]))
                .thenRun(() -> System.out.println("anyOf done"));

        Thread.sleep(1000);

    }
}
