package com.techarha.java.collections.recursion.questions;


import java.util.HashMap;
import java.util.Map;

/**
 * Given some money, and a set of Coins (of different denominations), find the number of ways we can disburse the money?
 */
public class CoinChange {


    public static long makeChangeRecursive(int money, int[] coins){
        return makeChangeRecursive(money, coins, 0);
    }

    public static long makeChangeRecursiveMemoized(int money, int[] coins){
        return makeChangeRecursiveMemoized(money, coins, 0, new HashMap<>());
    }

    public static long makeChangeBottomUp(int money, int[] coins){
        return makeChangeBottomUp(money, coins, 0, new HashMap<>());
    }

    private static long makeChangeRecursive(int money, int[] coins, int index) {
        if(money <= 0) return 1;
        if(index >= coins.length) return 0;

        int currentCoin = coins[index];
        if(money >= currentCoin) {
            return makeChangeRecursive(money - currentCoin, coins, index)
                + makeChangeRecursive(money, coins, index+1);
        } else {
            return makeChangeRecursive(money, coins, index+1);
        }
    }

    private static long makeChangeRecursiveMemoized(int money, int[] coins, int index, Map<String, Long> memo) {
        if(money <= 0) return 1;
        if(index >= coins.length) return 0;

        String key = money + "-" + index;

        if(memo.containsKey(key)) return memo.get(key);

        int currentCoin = coins[index];
        long ways;
        if(money >= currentCoin) {
            ways =  makeChangeRecursiveMemoized(money - currentCoin, coins, index, memo)
                + makeChangeRecursiveMemoized(money, coins, index+1, memo);
        } else {
            ways =  makeChangeRecursiveMemoized(money, coins, index+1, memo);
        }

        memo.put(key, ways);
        return ways;
    }

    private static long makeChangeBottomUp(int money, int[] coins, int index, HashMap<String, Long> memo) {
        if(money == 0) return 1;
        if(index >= coins.length) return 0;

        int amountWithCoin = 0;

        String key = money + "-" + index;
        if(memo.containsKey(key)) return memo.get(key);

        long ways = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChangeBottomUp(remaining, coins, index + 1, memo);
            amountWithCoin += coins[index];
        }
        memo.put(key, ways);

        return memo.get(key);
    }
}
