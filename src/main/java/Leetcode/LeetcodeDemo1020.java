package com.Leetcode;

/**
 * Leetcode1020,飞地的数量
 * DFS，BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo1020 {
    public int numEnclaves(int[][] grid)
    {
        //将边界上的1加入队列，看做超级源点连接的节点，进行BFS
        Deque<int[]> d = new ArrayDeque<>();

        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1)
                {
                    grid[i][j] = 0;
                    d.addLast(new int[]{i, j});
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1)
                {
                    grid[nx][ny] = 0;
                    d.addLast(new int[]{nx, ny});
                }
            }
        }

        //check
        int cnt = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    //DFS
    int[][] grid;
    int m, n;
    public int numEnclaves1(int[][] grid)
    {
        m = grid.length; n = grid[0].length;
        this.grid = grid;

        for(int i = 0; i < m; i++)
        {
            dfs(i, 0);
            dfs(i, n - 1);
        }

        for(int j = 0; j < n; j++)
        {
            dfs(0, j);
            dfs(m - 1, j);
        }

        //check
        int cnt = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    public void dfs(int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) return;

        grid[x][y] = 0;

        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
