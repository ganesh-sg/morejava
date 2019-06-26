package com.ganesh.learn.more.java.arrays;

public class AnagramChecker {
    public boolean isAnagram(String source, String target) {
        if (source.length() != target.length()) {
            return false;
        }

        //Convert both the strings to lower case
        source = source.toLowerCase();
        target = target.toLowerCase();


        int[] letters = new int[256];

        //Harry, rahary
        //H and r  => 2
        //a and a => 3
        //r and
        for (int i = 0; i < source.length(); i++) {
            char sourceChar = source.charAt(i);
            ++letters[sourceChar];
        }
        for (int i = 0; i < target.length(); i++) {
            char targetChar = target.charAt(i);
            if (letters[targetChar] == 0) {
                return false;
            }
            letters[targetChar]--;
        }
        return true;
    }

    public static void main(String[] args) {
        AnagramChecker anagramChecker = new AnagramChecker();
        System.out.println("Harg garh " + anagramChecker.isAnagram("Harg", "garh"));
        System.out.println("abbb aabb (false) " + anagramChecker.isAnagram("abbb", "aabb"));
        System.out.println("aaab baaa (true) " + anagramChecker.isAnagram("aaab", "baaa"));
        System.out.println("aaab bbba (false) " + anagramChecker.isAnagram("aaab", "bbba"));
        System.out.println("aaab abbb (false) " + anagramChecker.isAnagram("aaab", "abbb"));
        System.out.println("aabb aaab (false) " + anagramChecker.isAnagram("aabb", "aaab"));
        System.out.println("aabb abba (true) " + anagramChecker.isAnagram("aabb", "abba"));
        System.out.println("aabb baab (true) " + anagramChecker.isAnagram("aabb", "baab"));
        System.out.println("aabb abba (true) " + anagramChecker.isAnagram("aabb", "abba"));
        System.out.println("aabb bbaa (true) " + anagramChecker.isAnagram("aabb", "bbaa"));
        System.out.println("Hargi garh " + anagramChecker.isAnagram("Hargi", "garh"));
        System.out.println("Ganesh Harish " + anagramChecker.isAnagram("Ganesh", "Harish"));
    }
}
