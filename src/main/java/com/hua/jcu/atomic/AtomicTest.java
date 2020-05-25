package com.hua.jcu.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author huazai
 * @date 2020/4/1 20:28
 */
public class AtomicTest {
    public static void main(String[] args) throws InstantiationException {
        //通过unsafe获取实例对象
        Unsafe unsafe = getUnsafe();
        Test test = (Test)unsafe.allocateInstance(Test.class);
        System.out.println(test.get());
    }

    /**
     * 反射获取unsafe
     * @return
     */
    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe result = (Unsafe)field.get(null);
            return result;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
class Test {
    private int num = 0;

    public Test() {
        this.num = 3;
        System.out.println("===========");
    }

    public int get() {
        return num;
    }
}
