package com.techarha.java.collections.recursion.questions;


/**
 * A kid is running up the stairs/steps, he jumps 1 step, 2 steps or 3 steps at a time.
 * How many ways/paths are there up the stairs/steps, to reach the top using n stairs.
 *
 */
public class RecursiveStaircase {

    public static int countPathsForStaircase(int steps) {
        return countPathsRec(steps);
    }

    public static int countPathsForStaircaseMemoized(int steps) {
        int[] memo = new int[steps+1];
        return countPathsRecMemoized(steps, memo);
    }

    public static int countPathsForStaircaseBottomUp(int steps) {
        if(steps <= 0) return 0;

        int[] paths = new int[steps];

        paths[0] = 1;
        paths[1] = 2;
        paths[2] = 3;
        for(int stair = 3; stair < steps; stair++) {
            paths[stair] = paths[stair - 1] + paths[stair - 2] + paths[stair - 3];
        }

        return paths[steps-1];
    }

    private static int countPathsRec(int steps) {
        if(steps <= 0) return 0;
        if(steps == 1) return 1;
        if(steps == 2) return 2;
        if(steps == 3) return 3;

        return countPathsRec(steps - 1) + countPathsRec(steps - 2) + countPathsRec(steps - 3);
    }

    private static int countPathsRecMemoized(int steps, int[] memo) {
        if(steps <= 0) return 0;
        if(steps == 1) return 1;
        if(steps == 2) return 2;
        if(steps == 3) return 3;

        if(memo[steps] == 0)
            memo[steps] = countPathsRecMemoized(steps - 1, memo)
                            + countPathsRecMemoized(steps - 2, memo)
                            + countPathsRecMemoized(steps - 3, memo);

        return memo[steps];
    }
}
