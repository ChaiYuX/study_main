package com.dp.dp_sp.operate;

public class DoOperateDivision extends OperateStrategy{


    public DoOperateDivision() {
        super("DoOperateDivision");
    }

    @Override
    public int doOperate(int num1, int num2) {
        return num1/num2;
    }
}
