package com.hua.designPattern.singleThreadExecution_5;

/**
 * @author huazai
 * @date 2019/10/16 16:06
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("b1","beijing",gate);
        User sh = new User("s2","shanghai",gate);
        User gz = new User("g3","guangzhou",gate);

        bj.start();
        sh.start();
        gz.start();

    }
}
