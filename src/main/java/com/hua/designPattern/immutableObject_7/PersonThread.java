package com.hua.designPattern.immutableObject_7;

/**
 * @author huazai
 * @date 2019/10/17 13:28
 */
public class PersonThread extends Thread {

    private Person person;

    public PersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("【" + Thread.currentThread().getName() + "】 print " + person.toString());
        }
    }
}
