package com.dp.dp_sp.operate;

public abstract class OperateStrategy {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OperateStrategy(String name){
        this.name = name;
    }

    public abstract int doOperate(int num1 , int num2);

}
