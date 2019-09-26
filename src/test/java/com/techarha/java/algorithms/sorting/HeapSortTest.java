package com.techarha.java.algorithms.sorting;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import static org.junit.Assert.*;

public class HeapSortTest {

    @Test
    public void sort() {
        Integer[] input = new Integer[] { 25, 20, 21, 14, 9, 15, 18, 13, 12, 8, 7};
        Integer[] output = HeapSort.sort(input);

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
