package com.techarha.java.collections.recursion.questions;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciNumberTest {

    @Test
    public void nonMemoizedFibonacciNumberFor() {
        assertEquals(3, FibonacciNumber.nonMemoizedFibonacciNumberFor(4));
        assertEquals(5, FibonacciNumber.nonMemoizedFibonacciNumberFor(5));
        assertEquals(8, FibonacciNumber.nonMemoizedFibonacciNumberFor(6));
    }

    @Test
    public void memoizedFibonacciNumberFor() {
        assertEquals(3, FibonacciNumber.memoizedFibonacciNumberFor(4));
        assertEquals(5, FibonacciNumber.memoizedFibonacciNumberFor(5));
        assertEquals(8, FibonacciNumber.memoizedFibonacciNumberFor(6));
    }
}
