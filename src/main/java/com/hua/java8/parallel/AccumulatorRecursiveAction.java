package com.hua.java8.parallel;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huazai
 * @date 2019/7/30 14:17
 */
public class AccumulatorRecursiveAction extends RecursiveAction {

    private final int start;

    private final int end;

    private final int LIMIT = 3;

    private final int [] data;

    public AccumulatorRecursiveAction(int start, int end, int[] data) {
        this.start = start;
        this.end = end;
        this.data = data;
    }

    @Override
    protected void compute() {
        if((end - start) <= LIMIT){
//            int result = 0;
            for(int i = start;i < end;i++){
//                result += data[i];
                AccumulatorHelper.accumulate(data[i]);
            }
        } else {
            int mid = (end + start) / 2;
            AccumulatorRecursiveAction left = new AccumulatorRecursiveAction(start , mid ,data);
            AccumulatorRecursiveAction right = new AccumulatorRecursiveAction(mid , end ,data);
            left.fork();
            right.fork();
            left.join();
            right.join();
        }

    }

    static class AccumulatorHelper{

        private static final AtomicInteger RESULT = new AtomicInteger();

        static void accumulate(int value){
            RESULT.getAndAdd(value);
        }

        public static int getResult(){
            return RESULT.get();
        }

        static void reset(){
            RESULT.set(0);
        }

    }
}
