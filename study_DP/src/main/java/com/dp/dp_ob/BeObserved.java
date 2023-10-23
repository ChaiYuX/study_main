package com.dp.dp_ob;

public interface BeObserved {

    void registerObserver(Observe observer); // 注册观察者

    void removeObserver(Observe observer); //注销观察者

    void  observerAction();//通知观察者


}
