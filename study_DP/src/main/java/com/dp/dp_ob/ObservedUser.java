package com.dp.dp_ob;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察的人
 */
public class ObservedUser implements BeObserved {

    private List<Observe> observers = new ArrayList<>();

    private String action = "放屁";

    @Override
    public void registerObserver(Observe observe) {
        observers.add(observe);
    }

    @Override
    public void removeObserver(Observe observe) {
        System.out.println(observe.getClass().getSimpleName() + "观察者说：这人放屁 我不认识他");
        observers.remove(observe);
    }

    @Override
    public void observerAction() {
        System.out.println("被观察者说：哎呦 不小心偷偷" + action);
        observers.stream().forEach(item ->{
            item.dealAction(action);
        });
    }
}
