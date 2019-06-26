package com.ganesh.learn.more.java.arrays;

public class UniqueChars {

    public boolean isUnique(String input) {
        boolean[] chars = new boolean[256];

        for (int i = 0; i < input.length(); i++) {
            char strChar = input.charAt(i);
            if (chars[strChar]) {
                return false;
            }
            chars[strChar] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueChars uniqueChars = new UniqueChars();
        System.out.println("Is unique Ganesh " + uniqueChars.isUnique("Ganesh"));
        System.out.println("Is unique Harish " + uniqueChars.isUnique("Harish"));
        System.out.println("Is unique Harry " + uniqueChars.isUnique("Harry"));
        System.out.println("Is unique There will be blood " + uniqueChars.isUnique("There will be blood"));
    }

}
