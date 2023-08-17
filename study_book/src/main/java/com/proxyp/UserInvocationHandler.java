package com.proxyp;

import com.entity.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserInvocationHandler implements InvocationHandler {

    private User target;

    public UserInvocationHandler(User target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //TODO: 验证身份 如果是读书操作 需要校验这个人有没有这个书 这个书是不是这个人借的
        Object result = method.invoke(target, args);
        //TODO:输出对应信息
        return result;
    }
}
