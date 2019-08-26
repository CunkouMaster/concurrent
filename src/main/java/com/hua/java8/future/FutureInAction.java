package com.hua.java8.future;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author huazai
 * @date 2019/8/21 14:55
 */
public class FutureInAction {

    public static void main(String[] args) throws InterruptedException {
        Future<String> future = invoke(() -> {
            try {
                Thread.sleep(1000);
                return "I am finished";
            } catch (InterruptedException e) {
                return "Error";
            }
        });

        System.out.println(future.get() == null ? "is doing ..." : future.get());
        System.out.println(future.get() == null ? "is doing ..." : future.get());
        System.out.println(future.get() == null ? "is doing ..." : future.get());

        while (!future.isDone()){
            Thread.sleep(10);
        }

        System.out.println(future.get());


//        String block = block(() -> {
//            try {
//                Thread.sleep(1000);
//                return "I am finished";
//            } catch (InterruptedException e) {
//                return "Error";
//            }
//        });
//        System.out.println(block);
    }

    /**
     * 阻塞式
     * @param callable
     * @param <T>
     * @return
     */
    private static <T> T block(Callable<T> callable){
        return callable.action();
    }

    /**
     * 非阻塞式
     * @param callable
     * @param <T>
     * @return
     */
    private static <T> Future<T> invoke(Callable<T> callable){

        AtomicReference<T> result = new AtomicReference<>();
        AtomicBoolean finished = new AtomicBoolean();

        Thread thread = new Thread(() -> {
           T value = callable.action();
           result.set(value);
           finished.set(true);
        });

        thread.start();

        Future<T> future = new Future<T>() {
            @Override
            public T get() {
                return result.get();
            }

            @Override
            public boolean isDone() {
                return finished.get();
            }
        };

        return future;

    }

    interface  Future<T>{
        T get();

        boolean isDone();
    }

    private interface Callable<T> {
        T action();
    }
}
