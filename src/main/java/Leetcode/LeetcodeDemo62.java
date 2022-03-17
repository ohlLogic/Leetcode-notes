package com.Leetcode;

/**
 * Leetcode62,不同路径
 * 动态规划
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
public class LeetcodeDemo62 {
    public static void main(String[] args) {
        uniquePaths(3, 2);
    }

    public static int uniquePaths(int m, int n)
    {
        int[][] dp = new int[m + 1][n + 1];

        //初始状态
        dp[1][1] = 1;

        //状态转移
        for (int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(i != 1 || j != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

}
