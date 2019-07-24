package com.hua.java8.collector;

import com.hua.java8.Base;
import com.hua.java8.Dish;

import java.util.LinkedList;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @date 2019/7/24 16:08
 */
public class CollectorInAction02 {
    public static void main(String[] args) {
        //summingDouble
        Optional.ofNullable(
                Base.initDish().stream()
                        .collect(Collectors.summingDouble(Dish::getCalories))
        ).ifPresent(System.out::println);

        //toCollection
        LinkedList<Dish> linkedList = Base.initDish().stream()
                .filter(d -> d.getCalories()>600)
                .collect(Collectors.toCollection(LinkedList::new));
        Optional.ofNullable(linkedList).ifPresent(System.out::println);

        //toConcurrentMap
        ConcurrentMap<String, Integer> concurrentMap = Base.initDish().stream()
                .collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories));
        Optional.ofNullable(concurrentMap).ifPresent(System.out::println);

        ConcurrentMap<Dish.Type, Long> result = Base.initDish().stream()
                .collect(Collectors.toConcurrentMap(Dish::getType, v -> 1L, (a, b) -> a + b));
        Optional.ofNullable(result).ifPresent(System.out::println);

    }
}
