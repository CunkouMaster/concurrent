package com.hua.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author huazai
 * @date 2019/7/22 14:44
 */
public class StreamFind {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,8,6,10,12,2,5);

        Optional<Integer> any = list.stream().filter(i -> i % 2 == 0).findAny();
        System.out.println(any.get());
        Optional<Integer> any1 = list.stream().filter(i -> i > 20).findAny();
//        System.out.println(any1.get());
        System.out.println(any1.orElse(-1));

        Optional<Integer> first = list.stream().filter(i -> i % 2 == 0).findFirst();


    }
}
