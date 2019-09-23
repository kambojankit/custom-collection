package com.techarha.java.collections.recursion.questions;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveStaircaseTest {

    @Test
    public void countPathsForStaircase() {
        assertEquals(230, RecursiveStaircase.countPathsForStaircase(10));
        assertEquals(0, RecursiveStaircase.countPathsForStaircase(0));
        assertEquals(3, RecursiveStaircase.countPathsForStaircase(3));
    }

    @Test
    public void countPathsForStaircaseMemoized() {
        assertEquals(230, RecursiveStaircase.countPathsForStaircaseMemoized(10));
        assertEquals(0, RecursiveStaircase.countPathsForStaircaseMemoized(0));
        assertEquals(3, RecursiveStaircase.countPathsForStaircaseMemoized(3));
    }

    @Test
    public void countPathsForStaircaseBottopUp() {
        assertEquals(230, RecursiveStaircase.countPathsForStaircaseBottomUp(10));
        assertEquals(0, RecursiveStaircase.countPathsForStaircaseBottomUp(0));
    }
}
