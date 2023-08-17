package com.dp.dp_sp.meesage;

public class SuccMessage extends Strategy{

    public SuccMessage() {
        super("SuccMessage");
    }

    @Override
    public String sendMessage() {
        return "策略模式：输出：SuccMessage";
    }
}
