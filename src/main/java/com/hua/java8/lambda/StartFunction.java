package com.hua.java8.lambda;

import com.hua.java8.Apple;
import com.hua.java8.Base;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huazai
 * @date 2019/7/12 11:12
 */
public class StartFunction {

    /**
     *  1、接口有且仅有一个抽象方法
        2、允许定义静态方法
        3、允许定义默认方法
        4、允许java.lang.Object中的public方法
        5、该注解不是必须的，如果一个接口符合"函数式接口"定义，那么加不加该注解都没有影响。
            加上该注解能够更好地让编译器进行检查。如果编写的不是函数式接口，
            但是加上了@FunctionInterface，那么编译器会报错
     */
    @FunctionalInterface
    public interface AppleFilter{
        boolean filter(Apple apple);
    }

    private static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter){
        List<Apple> list = new ArrayList<>();
        for(Apple apple:apples){
            if(appleFilter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> lambdaResult = findApple(Base.initApples(),apple -> {
            return apple.getWeight() < 130 && ("red").equals(apple.getColor());
        } );

        System.out.println(lambdaResult);
    }

}
