package com.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 裁剪图片
 */
public class CroppingImages {

    public static void main(String[] args) {
        try {
            // 读取原始图片
            File inputFile = new File("C:\\Users\\dhgk\\Desktop\\250.jpg");
            BufferedImage inputImage = ImageIO.read(inputFile);

            // 定义截取的区域
            int x = 0;  // 起始横坐标
            int y = 300;  // 起始纵坐标
            int width = inputImage.getWidth();  // 截取宽度
            int height = inputImage.getHeight() - 300; // 截取高度

            // 进行图片截取
            BufferedImage outputImage = inputImage.getSubimage(x, y, width, height);

            // 保存截取后的图片
            String fileName = "Crop" + inputFile.getName();
            File outputFile = new File("C:\\Users\\dhgk\\Desktop\\" + fileName);
            System.out.println("截取图片保存名称：" + fileName);
            ImageIO.write(outputImage, "jpg", outputFile);

            System.out.println("图片截取成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
