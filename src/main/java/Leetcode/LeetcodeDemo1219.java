package com.Leetcode;

/**
 * Leetcode1219,黄金矿工
 * 回溯
 */
public class LeetcodeDemo1219 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] g;
    boolean[][] vis;
    int m, n;
    public int getMaximumGold(int[][] grid)
    {
        g = grid; m = grid.length; n = grid[0].length;
        vis = new boolean[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] != 0)
                {
                    vis[i][j] = true;
                    ans = Math.max(ans, dfs(i, j));
                    vis[i][j] = false;
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y)
    {
        int ans = g[x][y];
        for(int[] dir : dirs)
        {
            int nx = x + dir[0], ny = y + dir[1];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(g[nx][ny] == 0 || vis[nx][ny]) continue;
            vis[nx][ny] = true;
            ans = Math.max(ans, g[x][y] + dfs(nx, ny));
            vis[nx][ny] = false;
        }
        return ans;
    }

}
