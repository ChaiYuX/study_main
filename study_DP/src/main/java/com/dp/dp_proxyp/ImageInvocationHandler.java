package com.dp.dp_proxyp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ImageInvocationHandler implements InvocationHandler {

    private Image target;

    public ImageInvocationHandler(Image target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在调用目标对象之前可以执行一些额外的逻辑
        System.out.println("Before  " + method.getName() + "operation");
        // 调用目标对象的方法
        Object result = method.invoke(target , args);
        // 在调用目标对象之后可以执行一些额外的逻辑
        System.out.println("After  " + method.getName() + "operation");
        return result;
    }
}
