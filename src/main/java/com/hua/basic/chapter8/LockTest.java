package com.hua.basic.chapter8;

import java.util.Optional;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

/**
 * @author huazai
 * @date 2019/9/24 17:13
 */
public class LockTest {
    public static void main(String[] args) throws InterruptedException {
        final BooleanLockV1 booleanLockV1 = new BooleanLockV1();

        final BooleanLockV2 booleanLockV2 = new BooleanLockV2();

        Stream.of("T1","T2","T3","T4","T5").forEach(name ->
                new Thread(() -> {
                    try {
//                        booleanLockV1.lock();
//                        booleanLockV2.lock();
                        booleanLockV2.lock(100);
                        Optional.of(Thread.currentThread().getName() + " get the lock")
                                .ifPresent(System.out::println);
                        work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        Optional.of(Thread.currentThread().getName() + e.getMessage()).ifPresent(System.out::println);
                    } finally {
//                        booleanLockV1.unlock();
                        booleanLockV2.unlock();
                    }

                },name).start()
        );

//        Thread.sleep(100);
//        booleanLockV2.unlock();

    }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is working ......")
                .ifPresent(System.out::println);
        Thread.sleep(30_000);
    }


}
