package com.hua.java8.optional;

import com.hua.java8.Insurance;

import java.util.Optional;

/**
 * @author huazai
 * @date 2019/7/23 9:59
 */
public class OptionalUsage {

    public static void main(String[] args) {
        /**
         * Option创建：
         * 1、通过Optional.empty() -- 值为空
         * 2、通过Optional.of(T value) -- 值为传入的引用，value不为null
         * 3、通过Optional.ofNullable(T value) -- 前两者结合 ，value可为null
         */
        Optional<Insurance> insuranceOptional = Optional.empty();
//        insuranceOptional.get();空报错

        Optional<Insurance> insuranceOptional01 = Optional.of(new Insurance());
//        insuranceOptional01.get();返回空值

        Optional<Insurance> optional = Optional.ofNullable(null);

        //不同的get 方法
//        optional.orElseGet(Insurance::new);
//        optional.orElse(new Insurance());
//        optional.orElseThrow(RuntimeException::new);
//        optional.orElseThrow(() -> new RuntimeException("not have reference"));

        //方法介绍
        //过滤
        Insurance insuranceResult = insuranceOptional01
                .filter(insurance -> insurance.getName() == null).get();
        System.out.println(insuranceResult);
        //转换
        Optional<String> nameOption = insuranceOptional01
                .map(insurance -> insurance.getName());
        System.out.println(nameOption.orElse("name is null"));
        System.out.println(nameOption.isPresent());
        nameOption.ifPresent(System.out::println);


    }


    private static String getInsuranceName(Insurance insurance){
        String name = Optional.ofNullable(insurance).map(Insurance::getName)
                .orElse("unkonow");

        return name;
    }
}
