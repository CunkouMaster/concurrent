package com.hua.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author huazai
 * @date 2019/7/24 17:01
 */
public class ToListCollector<T> implements Collector<T ,List<T> ,List<T>> {

    private void log(final String log){
        System.out.println(Thread.currentThread().getName() + "-" + log);
    }
    /**
     *
     * @return
     */
    @Override
    public Supplier<List<T>> supplier() {
        log("supplier");
        return ArrayList::new;
    }

    /**
     * 入参消费
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        log("accumulator");
        return List::add;
    }

    /**
     *
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        log("combiner");
        return (list01,list02) -> {
            list01.addAll(list02);
            return list01;
        };
    }

    /**
     * 最终返回
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        log("finisher");
        return t -> t;
    }

    /**
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        log("characteristics");
        return Collections.unmodifiableSet(
                EnumSet.of(Characteristics.IDENTITY_FINISH,Characteristics.CONCURRENT)
        );
    }
}
