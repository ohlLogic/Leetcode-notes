package com.Leetcode;

/**
 * Leetcode1034,边界着色
 * DFS
 */
public class LeetcodeDemo1034 {
    int[][] grid;
    int[][] vis;
    int m, n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color)
    {
        this.grid = grid; this.m = grid.length; this.n = grid[0].length;
        vis = new int[m][n];
        dfs(row, col, grid[row][col]);

        //check
        for(int i = 1; i < m - 1; i++)
        {
            for(int j = 1; j < n - 1; j++)
            {
                //如果是联通分量内部点
                if(check(i, j)) vis[i][j] = -2;
            }
        }

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(vis[i][j] == -1) grid[i][j] = color;
            }
        }

        return grid;
    }


    //-1表示访问过
    public void dfs(int x, int y, int color)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || vis[x][y] == -1 || grid[x][y] != color) return;

        vis[x][y] = -1;

        dfs(x + 1, y, color);
        dfs(x - 1, y, color);
        dfs(x, y + 1, color);
        dfs(x, y - 1, color);
    }

    public boolean check(int x, int y)
    {
        if(vis[x][y] == -1 && vis[x][y + 1] != 0 && vis[x][y - 1] != 0 && vis[x + 1][y] != 0 && vis[x - 1][y] != 0) return true;
        return false;
    }
}
