package com.ganesh.learn.more.java.arrays;

public class RemoveDuplicates {
    public String remove(String source) {
        char[] sourceArray = source.toCharArray();

        if (sourceArray.length < 2) {
            return source;
        }


        /*
          tail = 1
          i = 1
          a!=b

          tail=2
          i=2

          tail=2
          i=3

          tail=2
          i=4

          tail=3
          abc

          i=5
          tail=3

          i=6
          tail[3] = d
        */
        int tail = 1;
        for (int i = 1; i < sourceArray.length; i++) {
            // ababccd
            int j;
            for (j = 0; j < tail; j++) {
                if (sourceArray[i] == sourceArray[j]) {
                    break;
                }
            }

            if (j == tail) { // <= This condition means that we found another unique character
                sourceArray[tail] = sourceArray[i];
                tail++;
            }
        }
        char[] targetArray = new char[tail];
        System.arraycopy(sourceArray, 0, targetArray, 0, tail);
        return String.valueOf(targetArray);
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(" ab " + removeDuplicates.remove("ab"));
        System.out.println(" aba " + removeDuplicates.remove("aba"));
        System.out.println(" abab " + removeDuplicates.remove("abab"));
        System.out.println(" ababc " + removeDuplicates.remove("ababc"));
        System.out.println(" abaabacccd " + removeDuplicates.remove("abcd"));
    }
}
