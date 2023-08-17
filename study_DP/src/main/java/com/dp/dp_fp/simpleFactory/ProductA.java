package com.dp.dp_fp.simpleFactory;

public class ProductA implements Product{
    @Override
    public void doOperater() {
        System.out.println(ProductA.class.getName());
    }
}
