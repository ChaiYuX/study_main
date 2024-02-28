package com.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Img2Base64 {

    public static void main(String[] args) {
        try {
            // 图片文件路径
            String imagePath = "C:\\Users\\dhgk\\Desktop\\250.jpg";

            // 读取图片文件为字节数组
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));

            // 使用Base64编码
            String base64String = Base64.getEncoder().encodeToString(imageBytes);
            // 输出Base64字符串
            System.out.println(base64String);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
