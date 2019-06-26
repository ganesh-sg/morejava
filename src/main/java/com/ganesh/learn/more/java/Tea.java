package com.ganesh.learn.more.java;

public class Tea {

    private String taste;
    private int sugar;

    public Tea(String taste, int sugar) {
        this.taste = taste;
        this.sugar = sugar;
    }

    public Tea() {

    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "taste='" + taste + '\'' +
                ", sugar=" + sugar +
                '}';
    }
}
