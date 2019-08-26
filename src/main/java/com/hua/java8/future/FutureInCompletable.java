package com.hua.java8.future;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author huazai
 * @date 2019/8/26 13:20
 */
public class FutureInCompletable {

    public static void main(String[] args) {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(1000L);
                return "I am finished";
            } catch (InterruptedException e) {
                return "Error";
            }
        });

        future.setCompletable(new Completable<String>() {
            @Override
            public void complete(String s) {
                System.out.println(s);
            }

            @Override
            public void exception(Throwable cause) {
                System.out.println("error");
                cause.printStackTrace();
            }
        });

        System.out.println(".........");
        System.out.println(future.get() == null ? "is doing ..." : future.get());
        System.out.println(future.get() == null ? "is doing ..." : future.get());

    }

    /**
     * 简单模拟CompletableFuture
     * @param callable
     * @param <T>
     * @return
     */
    private static <T> Future<T> invoke(Callable<T> callable){

        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean();

        Future<T> future = new Future<T>() {
            private Completable<T> completable;

            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }

            @Override
            public void setCompletable(Completable<T> completable) {
                this.completable = completable;
            }

            @Override
            public Completable<T> getCompletable() {
                return completable;
            }
        };

        Thread thread = new Thread(() -> {
            try {
                T value = callable.action();
                result.set(value);
                finished.set(true);
                if(future.getCompletable() != null){
                    future.getCompletable().complete(value);
                }

            } catch (Exception cause) {
                if(future.getCompletable() != null){
                    future.getCompletable().exception(cause);
                }
            }
        });

        thread.start();

        return future;

    }

    private interface  Future<T>{
        T get();

        boolean isDone();

        void setCompletable(Completable<T> completable);

        Completable<T> getCompletable();
    }

    private interface Callable<T> {
        T action();
    }

    private interface Completable<T>{
        void complete(T t);

        void exception(Throwable cause);
    }
}
