package com.dp.dp_fp.factory;

import com.dp.dp_fp.simpleFactory.Product;
import com.dp.dp_fp.simpleFactory.ProductA;

public class Factory1 implements Factory{


    @Override
    public Product createFactory() {
        return new ProductA();
    }

}
