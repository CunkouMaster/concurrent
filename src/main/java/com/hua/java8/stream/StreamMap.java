package com.hua.java8.stream;

import com.hua.java8.Base;
import com.hua.java8.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huazai
 * @date 2019/7/22 13:30
 */
public class StreamMap {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,8,6,10,12,2,5);

        //增大两倍
        List<Integer> collect = list.stream().map(i -> i * 2).collect(Collectors.toList());
        System.out.println(collect);

        //获取名称
        List<String> collect1 = Base.initDish().stream().map(Dish::getName).collect(Collectors.toList());
        System.out.println(collect1);

        //扁平化stream
        String [] words = {"hello","world","apple"};
        //{h,e,l,l,o},{w,o,r,l,d}
        Stream<String[]> wordStream = Arrays.stream(words).map(word -> word.split(""));
        //h,e,l,l,o,w,o,r,l,d
        Stream<String> stringStream = wordStream.flatMap(Arrays::stream);
        stringStream.distinct().forEach(System.out::print);
    }
}
