package com.hua.designPattern.future_8;


import java.util.function.Consumer;

/**
 * @author huazai
 * @date 2019/10/18 13:24
 */
public class FutureService {

    /**
     * 类似轮询方式
     * @param task
     * @param <T>
     * @return
     */
    public <T> Future<T> submit(final FutureTask<T> task){

        AsyncFuture<T> asyncFuture = new AsyncFuture<>();

        new Thread(() -> {
            T result = task.call();
            asyncFuture.done(result);
        }).start();

        return asyncFuture;

    }

    /**
     * callback方式
     * @param task
     * @param <T>
     * @return
     */
    public <T> Future<T> submit(final FutureTask<T> task, final Consumer<T> consumer){

        AsyncFuture<T> asyncFuture = new AsyncFuture<>();

        new Thread(() -> {
            T result = task.call();
            asyncFuture.done(result);
            consumer.accept(result);
        }).start();

        return asyncFuture;

    }
}
