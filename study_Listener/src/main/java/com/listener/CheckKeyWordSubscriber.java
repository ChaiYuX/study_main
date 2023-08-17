package com.listener;

public class CheckKeyWordSubscriber implements CheckKeyWordListener{


    @Override
    public void onEvent(String value) {
        System.out.println("未检测到关键字 可以正常发送 : " + value );
    }
}
