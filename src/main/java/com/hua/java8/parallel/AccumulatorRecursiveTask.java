package com.hua.java8.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * @author huazai
 * @date 2019/7/30 14:05
 */
public class AccumulatorRecursiveTask extends RecursiveTask<Integer> {

    private final int start;

    private final int end;

    private final int LIMIT = 3;

    private final int [] data;

    public AccumulatorRecursiveTask(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected Integer compute() {
        if((end - start) <= LIMIT){
            int result = 0;
            for(int i = start;i < end;i++){
                result += data[i];
            }
            return result;
        }

        int mid = (end + start) / 2;
        AccumulatorRecursiveTask left = new AccumulatorRecursiveTask(start , mid ,data);
        AccumulatorRecursiveTask right = new AccumulatorRecursiveTask(mid , end ,data);
        left.fork();
        Integer rightResult = right.compute();
        Integer leftResult = left.join();

        return leftResult + rightResult;
    }
}
