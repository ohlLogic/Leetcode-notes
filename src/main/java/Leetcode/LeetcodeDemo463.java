package com.Leetcode;

/**
 * Leetcode463,岛屿周长
 */
public class LeetcodeDemo463 {
    int m, n;
    int[][] grid;
    public int islandPerimeter(int[][] grid) {
        m = grid.length; n = grid[0].length;
        this.grid = grid;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) return dfs(i, j);
            }
        }
        return 0;
    }

    public int dfs(int x, int y)
    {
        //超过网格范围，返回区域边界
        if(x < 0 || x >= m || y < 0 || y >= n) return 1;

        //海洋区域
        if(grid[x][y] == 0) return 1;

        //已经标记的
        if(grid[x][y] == 2) return 0;

        //已经遍历过，标记为2
        grid[x][y] = 2;

        //模拟四个方向
        return dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y + 1) + dfs(x, y - 1);
    }
}
