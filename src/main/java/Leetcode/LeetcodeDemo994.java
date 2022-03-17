package com.Leetcode;

/**
 * Leetcode994,腐烂的橘子
 * BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo994 {
    public int orangesRotting(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> d = new ArrayDeque<>();

        //将所有腐烂的橘子加入队列d
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 2) d.addLast(new int[]{i, j});
            }
        }
        if(d.isEmpty())
        {
            for(int i = 0; i < m; i++)
            {
                for(int j = 0; j < n; j++)
                {
                    if(grid[i][j] == 1) return -1;
                }
            }
            return 0;
        }
        //BFS
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int cnt = 0;
        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1)
                {
                    grid[nx][ny] = grid[x][y] + 1;
                    d.addLast(new int[]{nx, ny});
                }
            }
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) return -1;
                cnt = Math.max(grid[i][j], cnt);
            }
        }
        return cnt - 2;
    }
}
