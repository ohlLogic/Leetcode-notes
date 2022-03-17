package com.Leetcode;

/**
 * Leetcode807,保持城市天际线
 */

import java.util.Arrays;

public class LeetcodeDemo807 {
    public int maxIncreaseKeepingSkyline(int[][] grid)
    {
        int m = grid.length, n = grid[0].length;

        int[] col = new int[n], row = new int[m];

        //查找每行最大值
        for(int i = 0; i < m; i++) row[i] = getMax(grid[i]);

        //转置
        int[][] temp = new int[n][m];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                temp[j][i] = grid[i][j];
            }
        }
        //查找每列最大值
        for(int i = 0; i < n; i++) col[i] = getMax(temp[i]);

        int ans = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                ans += Math.min(row[i], col[j]) - grid[i][j];
            }
        }
        return ans;
    }

    public int getMax(int[] arr)
    {
        int[] clone = arr.clone();
        int n = arr.length;
        Arrays.sort(clone);
        return clone[n - 1];
    }


    public int maxIncreaseKeepingSkyline1(int[][] grid)
    {
        int N = grid.length;
        int[] rowMaxes = new int[N];
        int[] colMaxes = new int[N];

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
            }

        int ans = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];

        return ans;
    }
}
