package com.entity;

public class Book {

    /**
     * 书本内容
     */
    private String content;

    /**
     * 前言
     */
    private String intro;

    /**
     * 书名
     */
    private String name;

    /**
     * 是否被解约
     */
    private boolean hasUsed;

    /**
     * 拥有者的姓名
     */
    private  String ownerName;

    public Book(String content, String intro, String name, boolean hasUsed, String ownerName) {
        this.content = content;
        this.intro = intro;
        this.name = name;
        this.hasUsed = hasUsed;
        this.ownerName = ownerName;
    }

    public Book() {
    }

    public boolean isHasUsed() {
        return hasUsed;
    }

    public void setHasUsed(boolean hasUsed) {
        this.hasUsed = hasUsed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "content='" + content + '\'' +
                ", intro='" + intro + '\'' +
                ", name='" + name + '\'' +
                ", hasUsed='" + hasUsed + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
