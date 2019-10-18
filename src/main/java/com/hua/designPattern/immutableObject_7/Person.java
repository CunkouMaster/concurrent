package com.hua.designPattern.immutableObject_7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  不可变对象 Immutable Object
 *  Tips: 不可变对象一定是线程安全的，可变对象不一定是线程不安全的（StringBuffer）
 * @author huazai
 * @date 2019/10/16 16:03
 */
public final class Person{

    private final String name;
    private final String address;
    private final List<Object> details;

    public Person(final String name, final String address, List<Object> details) {
        this.name = name;
        this.address = address;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    //让可变list只读
    public List<Object> getDetails() {
        return Collections.unmodifiableList(details);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
