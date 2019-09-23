package com.techarha.java.collections.arrays.questions.strings;

/**
 * Given two strings (lowercase a-z), how many characters do we need to remove (from either), to make them Anagrams?
 * Example: hello , billion :: Answer -> 6 (remove 'he' from hello and 'biin' from billion)
 *
 * Two strings are anagrams, if they contain same characters, in different order.
 */
public class AnagramProblem {

    private static final int ALPHABETS_COUNT = 26;

    public static int charCountToTurnAnagrams(String first, String second) {
        int[] firstCharCount = findCharCount(first.toLowerCase());
        int[] secondCharCount = findCharCount(second.toLowerCase());

        return getDelta(firstCharCount, secondCharCount);
    }

    private static int getDelta(int[] firstCharCount, int[] secondCharCount) {
        int delta = 0;
        for (int i = 0; i < ALPHABETS_COUNT; i++) {
            int difference = Math.abs(firstCharCount[i] - secondCharCount[i]);
            delta += difference;
        }
        return delta;
    }

    private static int[] findCharCount(String input) {
        int[] charCount = new int[ALPHABETS_COUNT];

        for (char ch : input.toCharArray()) {
            int index = getIndex(ch);
            charCount[index]++;
        }
        return charCount;
    }

    private static int getIndex(char ch) {
        return ch - 'a';
    }
}
