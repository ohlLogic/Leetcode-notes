package com.Leetcode;

/**
 * Leetcode200,岛屿数量
 */

public class LeetcodeDemo200 {
    int m, n;
    char[][] grid;
    boolean[][] vis;

    public int numIslands(char[][] grid) {
        m = grid.length; n = grid[0].length;
        this.grid = grid;
        vis = new boolean[m][n];
        int cnt = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(!vis[i][j] && grid[i][j] == '1')
                {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || vis[x][y] || grid[x][y] == '0') return;

        vis[x][y] = true;
        //模拟四个方向
        dfs(x + 1, y);
        dfs(x, y + 1);
        dfs(x - 1, y);
        dfs(x, y - 1);
    }
}
