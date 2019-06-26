package com.ganesh.learn.more.java.functions;

public class UseFirstFunction {

    public boolean useFunction(int value) {
        FirstFunction oddTester = i -> i % 2 == 0;
        return oddTester.test(value);
    }

    public static void main(String[] args) {
        UseFirstFunction useFirstFunction = new UseFirstFunction();
        System.out.println("Is even " + useFirstFunction.useFunction(11));
        System.out.println("Is odd " + useFirstFunction.useFunction(12));
    }
}
