package com.techarha.java.algorithms.searching;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void isPresent() {
        int[] arr = new int[] {2, 3, 4, 7, 8, 9, 11, 13, 16, 19, 21, 44};

        assertEquals(true, BinarySearch.isPresent(arr, 7));
    }
}
