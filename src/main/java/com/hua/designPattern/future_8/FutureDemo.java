package com.hua.designPattern.future_8;

/**
 * Future           -->代表未来的一个凭据
 * FutureTask       -->将你的调用逻辑进行隔离
 * FutureService    -->桥接 Future 和 FutureTask
 *
 * @author huazai
 * @date 2019/10/18 13:34
 */
public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "FINISH";
        },  System.out::println);

        System.out.println("================");

        System.out.println(">>>>>>> do other thing >>>>>>>>");
        Thread.sleep(1000);
        System.out.println("================");

//        System.out.println(future.get());

    }
}
