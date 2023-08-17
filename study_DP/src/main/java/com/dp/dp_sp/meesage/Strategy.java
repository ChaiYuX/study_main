package com.dp.dp_sp.meesage;

public abstract class Strategy {

    protected String name;

    public Strategy (String name){
        this.name = name;
    }

    public abstract String sendMessage();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
