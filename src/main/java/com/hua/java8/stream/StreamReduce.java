package com.hua.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author huazai
 * @date 2019/7/22 14:53
 */
public class StreamReduce {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //计算总和
        Integer reduce = list.stream().reduce(0, (i, j) -> i + j);
        System.out.println(reduce);

        list.stream().reduce( (i, j) -> i + j).ifPresent(System.out::println);

        //筛选最大值
        list.stream().reduce(Integer::max).ifPresent(System.out::println);
        list.stream().reduce(
                (i,j) -> i>j?i:j
        ).ifPresent(System.out::println);

        //计算奇数积
        list.stream().filter(i -> i % 2 > 0)
                .reduce((i, j) -> i * j)
                .ifPresent(System.out::println);
    }

}
