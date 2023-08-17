package com.dp.dp_fp.simpleFactory;

public class ProductB implements Product{
    @Override
    public void doOperater() {
        System.out.println(ProductB.class.getName());
    }
}
