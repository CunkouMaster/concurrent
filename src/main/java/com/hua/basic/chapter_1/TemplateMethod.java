package com.hua.basic.chapter_1;

/**
 * @author huazai
 * @date 2019/7/3 16:13
 */
public class TemplateMethod {
    public final void templateMethod(){
        System.out.println("******************************");
        print();
        System.out.println("******************************");
    }

    protected void print(){
        // override this method
    }

    public static void main(String[] args) {
        TemplateMethod t = new TemplateMethod(){
            @Override
            protected void print() {
                System.out.println("** template method **");
            }
        };
        t.templateMethod();
    }

}
