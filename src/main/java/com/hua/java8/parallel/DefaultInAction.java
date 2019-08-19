package com.hua.java8.parallel;

/**
 * @author huazai
 * @date 2019/8/19 16:35
 */
public class DefaultInAction {



    private interface A {
        default void hello(){
            System.out.println("===A.hello===");
        }
    }


    private interface B extends A{
        @Override
        default void hello(){
            System.out.println("===B.hello===");
        }
    }


    private static class C implements B,A{
        @Override
        public void hello(){
            System.out.println("===C.hello===");
        }
    }

    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}
