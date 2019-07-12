package com.hua.java8.lambda;

import com.hua.java8.Apple;
import com.hua.java8.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * @author huazai
 * @date 2019/7/12 14:19
 */
public class LambdaUsage {

    /**
     * java.util.function.Predicate
     *
     * boolean test(T t)
     *
     * 返回boolean类型
     *
     * IntPredicate -- boolean test(int value)
     * LongPredicate -- boolean test(long value)
     * DoublePredicate -- boolean test(double value)
     * BiPredicate<T, U> -- boolean test(T t, U u)
     * @param source
     * @param predicate
     * @return
     */
    private static List<Apple> predicateFilter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple :source){
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //BiPredicate 参数为两个泛型
    private static List<Apple> biPredicateFilter(List<Apple> source,
                                                 BiPredicate<String,Integer> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple apple :source){
            if(predicate.test(apple.getColor(),apple.getWeight())){
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * java.util.function.Consumer
     *
     * void accept(T t)
     *
     * 无返回值void
     *
     * BiConsumer<T, U> -- void accept(T t, U u)
     * @param source
     * @param consumer
     * @return
     */
    private static void consumerFilter(List<Apple> source, Consumer<Apple> consumer){
        for(Apple apple :source){
           consumer.accept(apple);
        }
    }

    /**
     * java.util.function.Function<T, R>
     *
     * R apply(T t)
     *
     * 返回泛型R
     *
     * BiFunction<T, U, R> -- R apply(T t, U u)
     * @param apple
     * @return
     */
    private static String functionFilter(Apple apple , Function<Apple ,String> function){
        return function.apply(apple);

    }

    /**
     * java.util.function.Supplier<T>
     *
     * T get()
     *
     * 返回泛型T
     *
     * @param supplier
     * @return
     */
    private static Apple supplierFilter(Supplier<Apple> supplier){
        return supplier.get();

    }

    public static void main(String[] args) {
        List<Apple> predicateFilter = predicateFilter(Base.initApples(),
                apple -> "red".equals(apple.getColor()));
        System.out.println(predicateFilter);

        List<Apple> biPredicateFilter = biPredicateFilter(Base.initApples(),
                (s , i) -> "red".equals(s) && i > 150);
        System.out.println(biPredicateFilter);

        System.out.println("======================");
        //apple -> System.out.println(apple)
        consumerFilter(Base.initApples(), System.out::println);

        System.out.println("======================");
        System.out.println(functionFilter(new Apple("red",120), Apple::toString));

        System.out.println("======================");
        Supplier<String> s = String::new;
        System.out.println(s.get().getClass());

        Apple a = supplierFilter(() -> new Apple("green",100));
        System.out.println(a);

        // used in lambda expression should be final or effectively final
        int i = 0;
        Runnable r = () -> System.out.println(i);
//        i++;
    }
}
