package com.techarha.java.collections.recursion.questions;


/**
 * Given an NxN grid, with some obstacles, find the number of paths from start ( grid[0,0] ) till end ( grid[n, n])
 * such that user can either go right or down, in the grid.
 * <p>
 * Value true, at a grid cell, donates obstacle.
 */
public class CountGridPaths {

    public static int countPaths(boolean[][] grid) {
        return countPaths(grid, 0, 0);
    }

    public static int countPathsMemoized(boolean[][] grid) {
        int[][] pathCounter = new int[grid.length][grid.length];
        return countPaths(grid, 0, 0, pathCounter);
    }

    public static int countPathsBottomUp(boolean[][] grid) {
        int[][] pathCounter = new int[grid.length][grid.length];
        int rowEndIndex = grid.length - 1;
        int colEndIndex = grid.length - 1;

        // base condition
        pathCounter[rowEndIndex][colEndIndex] = 1;
        updateEndRow(grid, pathCounter, rowEndIndex, colEndIndex);
        updateEndColumn(grid, pathCounter, rowEndIndex, colEndIndex);

        for (int row = rowEndIndex - 1; row >=0 ; row--) {
            for (int col = colEndIndex - 1; col >=0 ; col--) {
                if(isValidPath(grid, row, col)) {
                    pathCounter[row][col] = pathCounter[row+1][col] + pathCounter[row][col+1];
                }else {
                    pathCounter[row][col] = 0;
                }
            }

        }

        return pathCounter[0][0];
    }

    private static void updateEndColumn(boolean[][] grid, int[][] pathCounter, int rowEndIndex, int colEndIndex) {
        for (int row = rowEndIndex - 1; row >= 0 ; row--) {
            if(isValidPath(grid, row, colEndIndex))
                pathCounter[row][colEndIndex] = pathCounter[rowEndIndex][colEndIndex];
        }
    }

    private static void updateEndRow(boolean[][] grid, int[][] pathCounter, int rowEndIndex, int colEndIndex) {
        for (int col = colEndIndex - 1; col >= 0 ; col--) {
            if(isValidPath(grid, rowEndIndex, col))
                pathCounter[rowEndIndex][col] = 1;
        }
    }

    private static int countPaths(boolean[][] grid, int row, int col, int[][] pathCounter) {
        if (!isValidPath(grid, row, col)) return 0;
        if (isAtEnd(grid, row, col)) return 1;
        if(pathCounter[row][col] == 0)
            pathCounter[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);

        return pathCounter[row][col];
    }

    private static int countPaths(boolean[][] grid, int row, int col) {
        if (!isValidPath(grid, row, col)) return 0;
        if (isAtEnd(grid, row, col)) return 1;

        return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
    }

    private static boolean isAtEnd(boolean[][] grid, int row, int col) {
        return row == grid.length - 1 && col == grid.length - 1;
    }

    private static boolean isValidPath(boolean[][] grid, int row, int col) {
        boolean isOutsideGridBoundry = row >= grid.length || col >= grid.length;
        if (isOutsideGridBoundry) return false;

        boolean isAnObstacle = grid[row][col];
        return !isAnObstacle;
    }
}
