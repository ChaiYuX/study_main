package com.dp.dp_sp.meesage;

public class FailMessage extends Strategy{

    public FailMessage() {
        super("FailMessage");
    }

    @Override
    public String sendMessage() {
        return "策略模式：输出：FailMessage";
    }
}
