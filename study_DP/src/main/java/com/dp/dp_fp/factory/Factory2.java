package com.dp.dp_fp.factory;

import com.dp.dp_fp.simpleFactory.Product;
import com.dp.dp_fp.simpleFactory.ProductB;

public class Factory2 implements Factory{
    @Override
    public Product createFactory() {
        return new ProductB();
    }



}
