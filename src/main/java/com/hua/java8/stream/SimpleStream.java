package com.hua.java8.stream;

import com.hua.java8.Base;
import com.hua.java8.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @date 2019/7/15 14:16
 */
public class SimpleStream {

    public static void main(String[] args) {

        /**
         * Calories小于400 的name 列表 从小到大顺序
         */
//        List<String> less400 = Base.initDish().stream()
//                .filter(e -> e.getCalories()<400)
//                .sorted(Comparator.comparing(Dish::getCalories))
//                .map(Dish::getName)
//                .collect(Collectors.toList());
        List<String> less400 = Base.initDish().parallelStream()
                .filter( e -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    return e.getCalories()<400 ;})
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(less400);

    }


}
