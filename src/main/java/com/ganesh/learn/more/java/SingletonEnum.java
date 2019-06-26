package com.ganesh.learn.more.java;

public enum SingletonEnum {
    INSTANCE;

    private int some;
    public void doSomething() {
        int some = this.some;
    }
}
