package com.hua.java8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
 * @author huazai
 * @date 2019/7/24 17:13
 */
public class CustomerInAction {
    public static void main(String[] args) {
        Collector<String,List<String>,List<String>> myCollector = new ToListCollector<>();

        String [] arrs = {"aa","bb","cc","dd","ab","ac","e"};

        List<String> result = Arrays.asList(arrs).parallelStream()
                .filter(s -> s.length() > 1)
                .collect(myCollector);

        System.out.println(result);
    }
}
