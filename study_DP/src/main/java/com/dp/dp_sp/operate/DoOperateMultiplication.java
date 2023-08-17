package com.dp.dp_sp.operate;

public class DoOperateMultiplication extends OperateStrategy{


    public DoOperateMultiplication() {
        super("DoOperateMultiplication");
    }

    @Override
    public int doOperate(int num1, int num2) {
        return num1 * num2;
    }
}
