package com.hua.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author huazai
 * @date 2019/7/12 11:12
 */
public class Base {

    public static List<Apple> initApples(){
        return apples;
    }

    private static List<Apple> apples = Arrays.asList(
            new Apple("red",100),
            new Apple("yellow",150),
            new Apple("green",130),
            new Apple("green",120),
            new Apple("red",160)
    );

    public static List<Dish> initDish(){
        return dish;
    }

    private static List<Dish> dish = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH)
    );

}
