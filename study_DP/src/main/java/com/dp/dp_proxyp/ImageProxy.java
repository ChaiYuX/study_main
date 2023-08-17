package com.dp.dp_proxyp;

/**
 * 静态代理
 */
public class ImageProxy implements Image {

    private String fileName;

    private RealImage realImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
