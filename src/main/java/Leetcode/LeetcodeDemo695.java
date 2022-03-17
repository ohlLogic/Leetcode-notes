package com.Leetcode;

/**
 * Leetcode695,岛屿的最大面积
 * dfs
 */
public class LeetcodeDemo695 {
    int m, n;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid)
    {
        m = grid.length; n = grid[0].length;
        this.grid = grid;
        int max = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) max = Math.max(max, dfs(i, j));
            }
        }
        return max;
    }

    public int dfs(int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return 0;

        grid[x][y] = 0;

        return dfs(x + 1, y) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x, y - 1) + 1;
    }
}
