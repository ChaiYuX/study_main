package com.dp.dp_sp.operate;

public class Operate {

    private OperateStrategy operateStrategy;

    public Operate (OperateStrategy operateStrategy){
        this.operateStrategy = operateStrategy;
    }

    public OperateStrategy getOperateStrategy() {
        return operateStrategy;
    }

    public void setOperateStrategy(OperateStrategy operateStrategy) {
        this.operateStrategy = operateStrategy;
    }

    public int doOperate(int num1 , int num2){
        return operateStrategy.doOperate(num1 , num2);
    }
}
