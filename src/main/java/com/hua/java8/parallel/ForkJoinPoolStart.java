package com.hua.java8.parallel;

import java.util.concurrent.ForkJoinPool;

/**
 * @author huazai
 * @date 2019/7/25 14:49
 */
public class ForkJoinPoolStart {

    private static int [] data = {1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        System.out.println("normalSum result ==>" + normalSum());
        //RecursiveTask
        AccumulatorRecursiveTask task = new AccumulatorRecursiveTask(0,data.length,data);
        ForkJoinPool pool = new ForkJoinPool();
        Integer result = pool.invoke(task);
        System.out.println("RecursiveTask result ==>" + result);
        //RecursiveAction
        AccumulatorRecursiveAction action = new AccumulatorRecursiveAction(0,data.length,data);
        pool.invoke(action);
        System.out.println("RecursiveAction result ==>" + AccumulatorRecursiveAction.AccumulatorHelper.getResult());

    }

    private static int normalSum (){
        int result = 0;
        for (int aData : data) {
            result += aData;
        }
        return result;
    }

}
