package com.dp.dp_sp.meesage;

public class OrtherMessage extends Strategy{

    public OrtherMessage() {
        super("OrtherMessage");
    }

    @Override
    public String sendMessage() {
        return "策略模式：输出：OrtherMessage";
    }
}
