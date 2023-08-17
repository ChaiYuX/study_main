package com.dp.dp_sp.operate;

public class DoOperateSubtraction extends OperateStrategy{


    public DoOperateSubtraction() {
        super("DoOperateSubtraction");
    }

    @Override
    public int doOperate(int num1, int num2) {
        return num1 - num2;
    }
}
