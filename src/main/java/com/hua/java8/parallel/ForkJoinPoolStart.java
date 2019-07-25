package com.hua.java8.parallel;

/**
 * @author huazai
 * @date 2019/7/25 14:49
 */
public class ForkJoinPoolStart {

    private static int [] data = {1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        System.out.println("normalSum result ==>" + normalSum());
    }

    private static int normalSum (){
        int result = 0;
        for(int i = 0 ;i<data.length;i++){
            result += data[i];
        }
        return result;
    }

}
