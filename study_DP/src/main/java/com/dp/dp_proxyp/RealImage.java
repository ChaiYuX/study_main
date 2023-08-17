package com.dp.dp_proxyp;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImage();
    }

    public void loadImage(){
        System.out.println("Loading image : " + this.fileName);
    }


    @Override
    public void display() {
        System.out.println("Display image ;" + this.fileName);
    }
}
