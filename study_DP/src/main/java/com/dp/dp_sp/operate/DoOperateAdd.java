package com.dp.dp_sp.operate;

public class DoOperateAdd extends OperateStrategy{


    public DoOperateAdd() {
        super("DoOperateSum");
    }

    @Override
    public int doOperate(int num1, int num2) {
        return num1 + num2;
    }
}
