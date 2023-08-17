package com.study;

import com.dp.dp_sp.operate.DoOperateMultiplication;
import com.dp.dp_sp.operate.OperateStrategy;
import com.entity.BaseEntity;
import com.entity.GrandsonEntity;

public class Main_test {

    public static void main(String[] args) {

        BaseEntity testEntity = new GrandsonEntity();
        System.out.println(testEntity.getClass().getSuperclass().getSimpleName());
        System.out.println(testEntity.getClass().getSimpleName());
        OperateStrategy testClass = new DoOperateMultiplication();
        System.out.println(testClass.getClass().getName());
        System.out.println(testClass.getName());
        OperateStrategy operateStrategy = new OperateStrategy("1") {
            @Override
            public int doOperate(int num1, int num2) {
                return 0;
            }
        };
        System.out.println(operateStrategy.getClass().getName());

    }

}
