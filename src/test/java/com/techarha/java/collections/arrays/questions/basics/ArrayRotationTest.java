package com.techarha.java.collections.arrays.questions.basics;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class ArrayRotationTest {

    @Test
    public void rotate2dArrayRight() {
        char[][] inputArr = generate2dArray();
        System.out.println("input array \n");
        System.out.println(print2DArray(inputArr));

        char[][] actualRotatedArr = ArrayRotation.rotateArray(inputArr);

        System.out.println();
        System.out.println("output array");
        System.out.println(print2DArray(actualRotatedArr));

        assertArrayEquals(expected2dArray(), actualRotatedArr);

    }

    private char[][] generate2dArray() {
        char[][] inputArr = new char[5][5];
        inputArr[0][0] = 'a';
        inputArr[0][1] = 'b';
        inputArr[0][2] = 'c';
        inputArr[0][3] = 'd';
        inputArr[0][4] = 'e';
        inputArr[1][0] = 'f';
        inputArr[1][1] = 'g';
        inputArr[1][2] = 'h';
        inputArr[1][3] = 'i';
        inputArr[1][4] = 'j';
        inputArr[2][0] = 'k';
        inputArr[2][1] = 'l';
        inputArr[2][2] = 'm';
        inputArr[2][3] = 'n';
        inputArr[2][4] = 'o';
        inputArr[3][0] = 'p';
        inputArr[3][1] = 'q';
        inputArr[3][2] = 'r';
        inputArr[3][3] = 's';
        inputArr[3][4] = 't';
        inputArr[4][0] = 'u';
        inputArr[4][1] = 'v';
        inputArr[4][2] = 'w';
        inputArr[4][3] = 'x';
        inputArr[4][4] = 'y';

        return inputArr;
    }

    private char[][] expected2dArray() {
        char[][] inputArr = new char[5][5];

        inputArr[0][0] = 'e';
        inputArr[0][1] = 'j';
        inputArr[0][2] = 'o';
        inputArr[0][3] = 't';
        inputArr[0][4] = 'y';
        inputArr[1][0] = 'd';
        inputArr[1][1] = 'i';
        inputArr[1][2] = 'n';
        inputArr[1][3] = 's';
        inputArr[1][4] = 'x';
        inputArr[2][0] = 'c';
        inputArr[2][1] = 'h';
        inputArr[2][2] = 'm';
        inputArr[2][3] = 'r';
        inputArr[2][4] = 'w';
        inputArr[3][0] = 'b';
        inputArr[3][1] = 'g';
        inputArr[3][2] = 'l';
        inputArr[3][3] = 'q';
        inputArr[3][4] = 'v';
        inputArr[4][0] = 'a';
        inputArr[4][1] = 'f';
        inputArr[4][2] = 'k';
        inputArr[4][3] = 'p';
        inputArr[4][4] = 'u';

        return inputArr;
    }


    private String print2DArray(char[][] input) {
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < input.length; i++) {

            printHorizontalBars(input, buffer);

            buffer.append(" | ");
            for (int j = 0; j < input.length; j++) {
                buffer.append(input[i][j] + " | ");
            }
            buffer.append("\n");
        }
        printHorizontalBars(input, buffer);
        buffer.append("\n");

        return buffer.toString();
    }

    private void printHorizontalBars(char[][] input, StringBuffer buffer) {
        buffer.append(" - ");
        for (int j = 0; j < input.length; j++) {
            buffer.append("-" + " - ");
        }
        buffer.append("\n");
    }
}
