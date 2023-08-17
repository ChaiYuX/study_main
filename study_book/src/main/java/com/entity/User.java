package com.entity;

public class User implements UserBehavior{

    private String name;

    private boolean hasVip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasVip() {
        return hasVip;
    }

    public void setHasVip(boolean hasVip) {
        this.hasVip = hasVip;
    }

    public User(String name, boolean hasVip) {
        this.name = name;
        this.hasVip = hasVip;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", hasVip=" + hasVip +
                '}';
    }

    @Override
    public void bookReturn(Book book) {
        book.setOwnerName("");
        book.setHasUsed(false);
    }

    @Override
    public void borrow(Book book) {
        book.setHasUsed(true);
        book.setOwnerName(this.name);
    }

    @Override
    public void read(Book book) {
        System.out.println(this.name + "正在读书 " +
                book.getName() +
                " 内容 :"
                + book.getContent());
    }
}
