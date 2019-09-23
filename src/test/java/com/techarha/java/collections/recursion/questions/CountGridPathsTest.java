package com.techarha.java.collections.recursion.questions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountGridPathsTest {

    @Test
    public void countPaths() {
        boolean[][] grid = prepareSampleGrid();

        assertEquals(27, CountGridPaths.countPaths(grid));
    }

    @Test
    public void countPathsBottomUp() {
        boolean[][] grid = prepareSampleGrid();

        assertEquals(27, CountGridPaths.countPathsBottomUp(grid));
    }

    @Test
    public void countPathsMemoized() {
        boolean[][] grid = prepareSampleGrid();

        assertEquals(27, CountGridPaths.countPathsMemoized(grid));
    }

    @Test
    public void countPathsMemoized2() {
        boolean[][] grid = prepareSampleGrid2();

        assertEquals(3, CountGridPaths.countPathsMemoized(grid));
    }

    private boolean[][] prepareSampleGrid() {
        boolean[][] grid = new boolean[8][8];
        grid[1][2] = true;
        grid[1][6] = true;
        grid[2][4] = true;
        grid[3][0] = true;
        grid[3][2] = true;
        grid[3][5] = true;
        grid[4][2] = true;
        grid[5][3] = true;
        grid[5][4] = true;
        grid[5][6] = true;
        grid[6][1] = true;
        grid[6][5] = true;

        return grid;
    }

    private boolean[][] prepareSampleGrid2() {
        boolean[][] grid = new boolean[3][3];
        grid[1][2] = true;
        return grid;
    }
}
