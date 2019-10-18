package com.hua.designPattern.immutableObject_7;

import java.util.stream.IntStream;

/**
 * @author huazai
 * @date 2019/10/17 13:30
 */
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("Alex","ShangHai", null);
        IntStream.range(0,5).forEach(i -> new PersonThread(person).start());
    }
}
