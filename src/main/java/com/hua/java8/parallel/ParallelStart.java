package com.hua.java8.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author huazai
 * @date 2019/7/24 17:22
 */
public class ParallelStart {
    public static void main(String[] args) {
        //cpu线程数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //change the size of pool
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");

        System.out.println("normal sum done in: " +
                measureSumPerf(ParallelStart::normal, 100_000_000) + " msecs");
        System.out.println("iterate sum done in: " +
                measureSumPerf(ParallelStart::iterateStream, 100_000_000) + " msecs");
        System.out.println("parallel sum done in: " +
                measureSumPerf(ParallelStart::parallelStream, 100_000_000) + " msecs");
        System.out.println("parallel2 sum done in: " +
                measureSumPerf(ParallelStart::parallelStream2, 100_000_000) + " msecs");
        System.out.println("parallel3 sum done in: " +
                measureSumPerf(ParallelStart::parallelStream3, 100_000_000) + " msecs");
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    private static long normal(long limit){
        long result = 0L;
        for(long i = 1L;i<limit;i++){
            result += i;
        }
        return result;
    }

    private static long iterateStream(long limit){
        return Stream.iterate(1L,i -> i+1)
                .limit(limit)
                .reduce(0L,Long::sum);
    }

    private static long parallelStream(long limit){
        return Stream.iterate(1L,i -> i+1)
                .parallel()
                .limit(limit)
                .reduce(0L,Long::sum);
    }

    //调整--去除自动拆箱
    private static long parallelStream2(long limit){
        return Stream.iterate(1L,i -> i+1)
                .mapToLong(Long::longValue)
                .parallel()
                .limit(limit)
                .reduce(0L,Long::sum);
    }

    //调整--用LongStream
    private static long parallelStream3(long limit){
        return LongStream.rangeClosed(1L, limit)
                .parallel()
                .reduce(0L,Long::sum);
    }
}
