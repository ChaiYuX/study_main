package com.listener;


import java.util.ArrayList;
import java.util.List;

/**
 * 关键字监听任务发布者
 */
public class CheckKeyWordPublisher {

    private List<CheckKeyWordListener> listeners = new ArrayList<>();

    public void addListeners(CheckKeyWordListener listener){
        listeners.add(listener);
    }

    public void removeListeners(CheckKeyWordListener listener){
        listeners.remove(listener);
    }

    public void publishEvent(String event){
        listeners.forEach( vo ->{
            vo.onEvent(event);
        });
    }

}
