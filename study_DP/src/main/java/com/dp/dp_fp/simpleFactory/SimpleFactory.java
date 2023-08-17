package com.dp.dp_fp.simpleFactory;

public class SimpleFactory {

    public static Product createProduct(int type){
        switch(type){
            case 1:
                return new ProductA();
            case 2:
                return new ProductB();

        }
        return null;
    }

}
