package com.Leetcode;

/**
 * Leetcode1765,地图中的最高点
 * 多源BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo1765 {
    public int[][] highestPeak(int[][] a)
    {
        int m = a.length, n = a[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(a[i][j] == 1) // 水域
                {
                    d.addLast(new int[]{i, j});
                }
                ans[i][j] = a[i][j] == 1 ? 0 : -1;
            }
        }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {-1, 0}};
        while(!d.isEmpty())
        {
            int[] poll  = d.pollFirst();
            int x = poll[0], y = poll[1];
            for(int[] dir : dirs)
            {
                int nx = x + dir[0], ny = y + dir[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || ans[nx][ny] != -1) continue;
                ans[nx][ny] = ans[x][y] + 1;
                d.addLast(new int[]{nx, ny});
            }
        }
        return ans;
    }
}
