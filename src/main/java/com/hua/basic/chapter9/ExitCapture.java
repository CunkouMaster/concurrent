package com.hua.basic.chapter9;

/**
 * @author huazaiqd
 * @date 2019/10/2 15:04
 */
public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("the application will be exit");
            notifyAndRelease();
        }));
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("I am working");
            } catch (Throwable e) {
                //ignore
            }
            i++;
            if(i>6){
                throw new RuntimeException("error");
            }
        }
    }

    private static void notifyAndRelease() {
        System.out.println("notify to the admin");
        try {
            Thread.sleep(1000);
        } catch (Throwable e) {
            //ignore
        }
        System.out.println("will release resource");
        try {
            Thread.sleep(1000);
        } catch (Throwable e) {
            //ignore
        }
        System.out.println("release and notify done");
    }

}
