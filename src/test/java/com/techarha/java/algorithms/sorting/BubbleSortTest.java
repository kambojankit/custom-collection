package com.techarha.java.algorithms.sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    CustomSort customSort;
    @Before
    public void setUp() throws Exception {
        customSort = new BubbleSort();
    }

    @Test
    public void sort() {
        Integer[] input = new Integer[] { 25, 20, 21, 14, 9, 15, 18, 13, 12, 8, 7};
        Integer[] actual = customSort.sort(input);

        Integer[] expected = new Integer[] { 7, 8, 9, 12, 13, 14, 15, 18, 20, 21, 25};
        for (int i = 0; i < actual.length; i++) {
            System.out.print(actual[i] + " ");
        }

        assertArrayEquals(expected, actual);
    }
}
