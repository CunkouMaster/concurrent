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

}
