package com.ganesh.learn.more.java;

public class Coffee {
    private String taste;
    private String sugar;

    public Coffee(String taste, String sugar) {
        this.taste = taste;
        this.sugar = sugar;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "taste='" + taste + '\'' +
                ", sugar='" + sugar + '\'' +
                '}';
    }
}
