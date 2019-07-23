package com.hua.java8.collector;

import com.hua.java8.Base;
import com.hua.java8.Dish;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collectors;

/**
 * @author huazai
 * @date 2019/7/23 13:54
 */
public class CollectorInAction {

    public static void main(String[] args) {

        //averagingDouble 平均
        Double avgDouble = Base.initDish().stream().collect(Collectors.averagingDouble(Dish::getCalories));
        Optional.ofNullable(avgDouble).ifPresent(System.out::println);

        //averagingInt 平均 -- 返回值仍为double
        Double avgInt = Base.initDish().stream().collect(Collectors.averagingInt(Dish::getCalories));
        Optional.ofNullable(avgInt).ifPresent(System.out::println);

        //averagingLong 平均 -- 返回值仍为double
        Double avgLong = Base.initDish().stream().collect(Collectors.averagingLong(Dish::getCalories));
        Optional.ofNullable(avgLong).ifPresent(System.out::println);

        //collectingAndThen 转换完成之后干什么
        String avgString = Base.initDish().stream()
                .collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), avg -> "The average is " + avg));
        Optional.ofNullable(avgString).ifPresent(System.out::println);

        //转化的list无法修改
        List<Dish> list = Base.initDish().stream().filter(dish -> Dish.Type.MEAT.equals(dish.getType()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
//        list.add(new Dish("McDonald's", false, 850, Dish.Type.OTHER));
        list.forEach(System.out::println);

        //counting 计数
        Long count = Base.initDish().stream().collect(Collectors.counting());
        Optional.ofNullable(count).ifPresent(System.out::println);

        //groupingBy
        Base.initDish().stream()
                .collect(Collectors.groupingBy(Dish::getType))
                .forEach((type, dishes) -> System.out.println("类型为" + type + "," + dishes));

        //计算分类平均值
        Map<Dish.Type, Double> avgResult = Base.initDish().stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.averagingInt(Dish::getCalories)));
        Optional.ofNullable(avgResult).ifPresent(System.out::println);
        //分类计数
        Map<Dish.Type, Long> countResult = Base.initDish().stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        Optional.ofNullable(countResult).ifPresent(System.out::println);
        System.out.println(countResult.getClass());

        //变换返回类型
        Map<Dish.Type, Long> mapResult = Base.initDish().stream()
                .collect(Collectors.groupingBy(Dish::getType, TreeMap::new, Collectors.counting()));
        System.out.println(mapResult.getClass());


        System.out.println("=============================");
        //summarizingInt
        IntSummaryStatistics result = Base.initDish().stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(result);

        //groupingByConcurrent
        ConcurrentMap<Dish.Type, List<Dish>> concurrentType = Base.initDish().stream()
                .collect(Collectors.groupingByConcurrent(Dish::getType));
        Optional.ofNullable(concurrentType).ifPresent(System.out::println);

        ConcurrentMap<Dish.Type, Long> concurrentResult = Base.initDish().stream()
                .collect(Collectors.groupingByConcurrent(Dish::getType, Collectors.counting()));
        Optional.ofNullable(concurrentResult).ifPresent(System.out::println);
        System.out.println(concurrentResult.getClass());

        ConcurrentSkipListMap<Dish.Type, Long> skipResult = Base.initDish().stream()
                .collect(Collectors.groupingByConcurrent(Dish::getType, ConcurrentSkipListMap::new, Collectors.counting()));
        System.out.println(skipResult.getClass());

        System.out.println("=============================");

        //1.joining -- static Collector<CharSequence,?,String>
        Optional.ofNullable(Base.initDish().stream().map(Dish::getName)
                .collect(Collectors.joining())).ifPresent(System.out::println);
        //2.joining加分隔符或前后缀
        Optional.ofNullable(Base.initDish().stream().map(Dish::getName)
                .collect(Collectors.joining(","))).ifPresent(System.out::println);
        Optional.ofNullable(Base.initDish().stream().map(Dish::getName)
                .collect(Collectors.joining(",","[","]"))).ifPresent(System.out::println);

        //mapping  等价于2.joining样例
        Optional.ofNullable(Base.initDish().stream()
                .collect(Collectors.mapping(Dish::getName,Collectors.joining(","))))
                .ifPresent(System.out::println);

        //maxBy -- 等价于.max(Comparator.comparing(Dish::getCalories))
        Base.initDish().stream().
                collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))
                .ifPresent(System.out::println);
        System.out.println("=============================");
        //partitioningBy
        Map<Boolean, List<Dish>> collect = Base.initDish().stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        Optional.ofNullable(collect).ifPresent(System.out::println);

    }
}
