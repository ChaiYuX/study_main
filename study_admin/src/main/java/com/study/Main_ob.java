package com.study;

import com.dp.dp_ob.ObserveUser1;
import com.dp.dp_ob.ObserveUser2;
import com.dp.dp_ob.ObservedUser;

public class Main_ob {

    public static void main(String[] args) {
        ObservedUser user = new ObservedUser();
        ObserveUser1 observe1 = new ObserveUser1();
        ObserveUser2 observe2 = new ObserveUser2();
        user.registerObserver(observe1);
        user.registerObserver(observe2);
        user.observerAction();
        user.removeObserver(observe2);
        user.removeObserver(observe1);
    }

}
