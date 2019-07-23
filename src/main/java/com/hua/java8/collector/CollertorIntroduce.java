package com.hua.java8.collector;

import com.hua.java8.Apple;
import com.hua.java8.Base;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @date 2019/7/23 11:16
 */
public class CollertorIntroduce {
    public static void main(String[] args) {
        //筛选出red apple
        List<Apple> greenList = Base.initApples().stream()
                .filter(apple -> "red".equals(apple.getColor()))
                .collect(Collectors.toList());
        Optional.ofNullable(greenList).ifPresent(System.out::println);

        //根据app 的 color 分组
        Base.initApples().stream()
                .collect(Collectors.groupingBy(Apple::getColor))
                .forEach((color, appleList) -> System.out.println("颜色" + color + "，序列" + appleList));
    }
    
}
