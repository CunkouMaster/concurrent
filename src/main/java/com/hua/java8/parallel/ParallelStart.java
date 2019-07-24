package com.hua.java8.parallel;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author huazai
 * @date 2019/7/24 17:22
 */
public class ParallelStart {
    public static void main(String[] args) {
        //cpu线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("normal sum done in: " +
                measureSumPerf(ParallelStart::normal, 10_000_000) + " msecs");
        System.out.println("iterate sum done in: " +
                measureSumPerf(ParallelStart::iterateStream, 10_000_000) + " msecs");
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

}
