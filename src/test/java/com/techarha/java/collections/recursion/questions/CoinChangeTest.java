package com.techarha.java.collections.recursion.questions;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {

    @Test
    public void makeChangeRecursive() {
        assertEquals(242, CoinChange.makeChangeRecursive(100, new int[] {25, 10, 5, 1}));
        assertEquals(104650, CoinChange.makeChangeRecursive(900, new int[] {25, 10, 5, 1}));
    }

    @Test
    public void makeChangeRecursiveMemoized() {
        assertEquals(242, CoinChange.makeChangeRecursiveMemoized(100, new int[] {25, 10, 5, 1}));
        assertEquals(104650, CoinChange.makeChangeRecursiveMemoized(900, new int[] {25, 10, 5, 1}));
    }

    @Test
    public void makeChangeBottomUp() {
        assertEquals(242, CoinChange.makeChangeBottomUp(100, new int[] {25, 10, 5, 1}));
        assertEquals(104650, CoinChange.makeChangeBottomUp(900, new int[] {25, 10, 5, 1}));
    }
}
