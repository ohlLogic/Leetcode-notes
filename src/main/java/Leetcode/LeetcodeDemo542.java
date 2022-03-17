package com.Leetcode;


/**
 * Leetcode542,01矩阵
 *
 */

import java.util.*;

public class LeetcodeDemo542 {

    //BFS
    public int[][] updateMatrix(int[][] mat)
    {
        int m = mat.length, n = mat[0].length;
        Deque<int[]> d = new ArrayDeque<>();

        //所有的0入队，将1设置为-1，表示未访问
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(mat[i][j] == 0) d.addLast(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            for(int i = 0; i < 4; i++)
            {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && mat[nx][ny] == -1)
                {
                    mat[nx][ny] = mat[x][y] + 1;
                    d.addLast(new int[]{nx, ny});
                }
            }
        }
        return mat;
    }

    //DP
    public int[][] updateMatrix1(int[][] mat)
    {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dp[i][j] = mat[i][j] == 0 ? 0 : 10000;
            }
        }

        // 从左上角开始
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        // 从右下角开始
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }
        return dp;
    }
}
