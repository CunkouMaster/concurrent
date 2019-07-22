package com.hua.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @date 2019/7/22 13:25
 */
public class StreamFilter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,8,6,10,12,2,5);

        //筛选
        List<Integer> collect = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        //去重
        List<Integer> collect1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect1);

        //跳过
        List<Integer> collect2 = list.stream().skip(5).collect(Collectors.toList());
        System.out.println(collect2);

        //前n个
        List<Integer> collect3 = list.stream().limit(5).collect(Collectors.toList());
        System.out.println(collect3);

    }
}
