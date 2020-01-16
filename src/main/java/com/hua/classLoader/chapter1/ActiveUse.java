package com.hua.classLoader.chapter1;

import java.util.Random;

/**
 * @author huazai
 * @date 2020/1/16 17:13
 */
public class ActiveUse {

    //访问某个类或者接口的静态变量，或者对该静态变量进行赋值操作
    //1.对某个类的静态变来那个进行读写 ->class
    //2.对接口中静态变量进行读取      ->interface
    public static void main(String[] args) throws ClassNotFoundException {
        //new，直接使用
//        new Obj();

        //访问某个类或接口的静态变量，或者对该静态变量进行复制操作
//        System.out.println(I.a);
//        System.out.println(Obj.salary);

        //调用静态方法
//        Obj.printSalary();

        //反射某个类
//        Class.forName("com.hua.classLoader.chapter1.Obj");

        //初始化一个子类  Obj和Child都初始化
//        System.out.println(Child.age);

        //(1)通过子类访问父类的static变量，不会导致子类的初始化.
//        System.out.println(Child.salary);

        //(2）定义引用数组，不会初始化类
//        Obj[] arrays = new Obj[10];

        //(3)final修饰的常量会在编译期间放到常量池中，不会初始化类
//        System.out.println(Obj.salary);

        //(4)final修饰的复杂类型，在编译期间无法计算得出，会初始化类
        System.out.println(Obj.x);

    }

}

class Obj{
    public static final long salary = 10000000L;

    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("Obj 被初始化");
    }

    public static void printSalary() {
        System.out.println("========Obj=printSalary");
    }

}

class Child extends Obj{

    public static int age = 22;

    static {
        System.out.println("child 被初始化");
    }
}

interface I{
    int a = 3;
}