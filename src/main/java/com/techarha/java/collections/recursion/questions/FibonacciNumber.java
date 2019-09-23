package com.techarha.java.collections.recursion.questions;


import static java.util.Objects.isNull;

/**
 * given a value, find the fibonacci number for the value
 */
public class FibonacciNumber {

    public static long nonMemoizedFibonacciNumberFor(int n) {
        return fibonacciSeriesBasic(n);
    }

    public static long memoizedFibonacciNumberFor(int n) {
        Long[] memo = new Long[n+1];
        return fibonacciSeriesMemoized(n, memo);
    }

    private static long fibonacciSeriesMemoized(int n, Long[] memo) {
        if(n == 0) return 0L;
        if(n == 1) return 1L;
        if(!isNull(memo[n]))
            return memo[n];

        memo[n] = fibonacciSeriesMemoized(n - 1, memo) + fibonacciSeriesMemoized(n - 2, memo);
        return memo[n];
    }

    private static long fibonacciSeriesBasic(int n) {
        if(n == 0) return 0L;
        if(n == 1) return 1L;

        return fibonacciSeriesBasic(n - 1) + fibonacciSeriesBasic(n - 2);
    }
}
