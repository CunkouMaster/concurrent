package com.hua.java8.lambda;

import com.hua.java8.Apple;
import com.hua.java8.Base;

import java.util.Comparator;
import java.util.List;

/**
 * @author huazai
 * @date 2019/7/12 13:32
 */
public class LambdaExpression {

    public static void main(String[] args) {

        /*
         * 主要两个包 function 和 stream --- java.util
         */
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        //与(o1,o2) -> o1.getColor().compareTo(o2.getColor())一致;
        Comparator<Apple> byColor2 = Comparator.comparing(Apple::getColor);

        List<Apple> list = Base.initApples();
        list.sort(byColor2);
        System.out.println(list);


    }

}
