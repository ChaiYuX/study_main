package com.study;

import com.listener.CheckKeyWordPublisher;
import com.listener.CheckKeyWordSubscriber;

public class Main_Listener {

    public static void main(String[] args) {

        Integer num1 = new Integer(1289878);
        int num2 = 1289878;
        Integer test = new Integer(1289878);
        int test2 = 1289878;

        System.out.println(num1.equals(num2));  // 比较两个Integer对象的值
        System.out.println(num1.intValue() == num2);
        System.out.println(num1 == num2);
        System.out.println(num1 == test);


        System.out.println(test == 1289878);
        System.out.println(test2 == 1289878);
        CheckKeyWordPublisher publisher = new CheckKeyWordPublisher();
        CheckKeyWordSubscriber subscriber1 = new CheckKeyWordSubscriber();
        CheckKeyWordSubscriber subscriber2 = new CheckKeyWordSubscriber();
        publisher.addListeners(subscriber2);
        publisher.addListeners(subscriber1);
        publisher.publishEvent("炒蛋");
        publisher.publishEvent("麻蛋");
        publisher.publishEvent("日购");
    }

}
