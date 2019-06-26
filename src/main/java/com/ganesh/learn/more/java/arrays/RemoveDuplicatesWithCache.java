package com.ganesh.learn.more.java.arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RemoveDuplicatesWithCache {
    public String remove(String source) {
        if(source == null || source.length() < 2) {
            return source;
        }

        char[] sourceCharArray = source.toCharArray();
        // Create a window of the unique characters starting with the first character.
        // Tail tracks the end of the window which starts at 0
        int tail = 1;
        boolean[] uniqueChars = new boolean[256];
        uniqueChars[sourceCharArray[0]] = true;

        for(int i=1; i< source.length(); i++) {

            if(!uniqueChars[sourceCharArray[i]]) {
                sourceCharArray[tail] = sourceCharArray[i];
                uniqueChars[sourceCharArray[i]] = true;
                tail++;
            }

        }

        char[] result = new char[tail];
        System.arraycopy(sourceCharArray, 0, result, 0, tail);
        return String.valueOf(result);
    }

    public static void main(String[] args) throws ParseException {
        RemoveDuplicatesWithCache removeDuplicates = new RemoveDuplicatesWithCache();
        System.out.println(" ab " + removeDuplicates.remove("ab"));
        System.out.println(" aba " + removeDuplicates.remove("aba"));
        System.out.println(" abab " + removeDuplicates.remove("abab"));
        System.out.println(" ababc " + removeDuplicates.remove("ababc"));
        System.out.println(" abaabacccd " + removeDuplicates.remove("abcd"));
        System.out.println(" aaabbb " + removeDuplicates.remove("aaabbb"));
        System.out.println(" abababa " + removeDuplicates.remove("abababa"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String dateString = format.format( new Date()   );
        Date   date       = format.parse ( "2009-12-31" );
        System.out.println("Formatted date "+ dateString);
        System.out.println("Parsed date "+ date);
    }
}
