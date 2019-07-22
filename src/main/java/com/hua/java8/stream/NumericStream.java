package com.hua.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/7/22 15:04
 */
public class NumericStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);


        //传统Stream
        Integer reduce = list.stream().filter(i -> i > 3).reduce(0, Integer::sum);
        System.out.println(reduce);

        //intStream 减少内存
        int sum = list.stream().mapToInt(Integer::intValue).filter(i -> i > 3).sum();
        System.out.println(sum);
        System.out.println("==========================");

        //1 -- 100
        int a = 9;
        IntStream.rangeClosed(1,100)
                .filter( i -> Math.sqrt(a * a + i * i) % 1 == 0)
                .boxed()
                .map(i -> new int[]{a,i, (int) Math.sqrt(a * a + i * i)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));
        System.out.println("==========================");
        IntStream.rangeClosed(1,100)
                .filter( i -> Math.sqrt(a * a + i * i) % 1 == 0)
                .mapToObj(i -> new int[]{a,i, (int) Math.sqrt(a * a + i * i)})
                .forEach(r -> System.out.println("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]));

    }

}
