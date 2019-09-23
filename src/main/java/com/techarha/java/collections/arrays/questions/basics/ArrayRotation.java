package com.techarha.java.collections.arrays.questions.basics;

import java.util.Arrays;

public class ArrayRotation {


    public static char[][] rotateArray(char[][] inputArr) {
        //find total levels
        int levels = inputArr.length / 2;
        for (int i = 0; i < levels; i++) {
            rotateArrayLevel(inputArr, i);
        }
        return inputArr;
    }

    private static void rotateArrayLevel(char[][] inputArr, int level) {
        char[] temp = Arrays.copyOf(inputArr[level], inputArr.length);

        rotateRightToTop(inputArr, level);
        rotateBottomToRight(inputArr, level);
        rotateLeftToBottom(inputArr, level);
        rotateTopToLeft(inputArr, level, temp);
    }

    private static void rotateTopToLeft(char[][] inputArr, int level, char[] temp) {
        for (int i = level; i < inputArr.length - level; i++) {
            inputArr[i][level] = temp[inputArr.length - 1 - i];
        }
    }

    private static void rotateLeftToBottom(char[][] inputArr, int level) {
        for (int i = inputArr.length - 1 - level; i >= level; i--) {
            inputArr[inputArr.length - 1 - level][i] = inputArr[i][level];
        }
    }

    private static void rotateBottomToRight(char[][] inputArr, int level) {
        for (int i = level; i < inputArr.length - level; i++) {
            inputArr[i][inputArr.length - 1 - level] = inputArr[inputArr.length - 1 - level][inputArr.length - 1 - i];
        }
    }

    private static void rotateRightToTop(char[][] inputArr, int level) {
        for (int i = level; i < inputArr.length - level; i++) {
            inputArr[level][i] = inputArr[i][inputArr.length - 1 - level];
        }
    }
}
