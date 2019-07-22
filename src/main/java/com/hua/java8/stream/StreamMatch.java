package com.hua.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author huazai
 * @date 2019/7/22 13:43
 */
public class StreamMatch {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,8,6,10,12,2,5);

        boolean b = list.stream().allMatch(i -> i > 0);
        System.out.println("所有元素大于0：" + b);

        boolean b1 = list.stream().anyMatch(i -> i >= 10);
        System.out.println("任一元素大于等于10：" + b1);

        boolean b2 = list.stream().noneMatch(i -> i > 15);
        System.out.println("所有元素都不大于15：" + b2);
    }
}
