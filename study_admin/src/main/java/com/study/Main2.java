package com.study;

import cn.hutool.core.util.StrUtil;
import com.dp.dp_proxyp.Image;
import com.dp.dp_proxyp.ImageInvocationHandler;
import com.dp.dp_proxyp.ImageProxy;
import com.dp.dp_proxyp.RealImage;
import com.logUtils.LogLevel;
import com.logUtils.LogProcessor;

import java.lang.reflect.Proxy;

public class Main2 {

    public static void main(String[] args) {

        System.out.println(System.currentTimeMillis());

        String url = "http://wh.nurse.cardcoo.net/auth/oauth/token";
        /**
         * 判断是否包含一下字符串  忽略大小写
         * 包含关系 &&
         */
        if (!StrUtil.containsAnyIgnoreCase(url
                ,  "/oauth/token" , "/phone/token/sms")) {
            System.out.println("进入");
        }

        LogProcessor processor = new LogProcessor();
        processor.processLog(LogLevel.INFO, "This is an information message.");
        processor.processLog(LogLevel.WARNING, "This is a warning message.");
        processor.processLog(LogLevel.ERROR, "This is an error message.");
//        System.out.println(Integer.valueOf(""));

        /**
         * 静态代理
         */
        processor.processLog(LogLevel.INFO , "============================= 静态代理 ===========================");
        Image image = new ImageProxy("xxxx.png");
        image.display();
        /**
         * 动态代理
         */
        processor.processLog(LogLevel.INFO , "============================= 动态代理 ===========================");
        Image target = new RealImage("ppp.png");
        Image image_active = (Image) Proxy.newProxyInstance(
                Image.class.getClassLoader(),
                new Class[]{Image.class},
                new ImageInvocationHandler(target)
        );
        image_active.display();
    }

}
