package com.hua.java8.optional;

import com.hua.java8.Car;
import com.hua.java8.Insurance;
import com.hua.java8.Person;

import java.util.Optional;

/**
 * @author huazai
 * @date 2019/7/23 10:39
 */
public class OptionalInAction {
    public static void main(String[] args) {
        System.out.println(getName(null));
    }

    private static String getName(Person person){
        String name = Optional.ofNullable(person).flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");

        return name;
    }
}
