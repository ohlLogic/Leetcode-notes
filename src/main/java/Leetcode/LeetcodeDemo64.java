package com.Leetcode;

/**
 * Leetcode64,最小路径和
 * 动态规划
 */
public class LeetcodeDemo64 {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6}};
        System.out.println(minPathSum(mat));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];

        //初始状态
        dp[1][1] = grid[0][0];
        for (int i = 2; i <= m; i++) dp[i][1] = dp[i - 1][1] + grid[i - 1][0];
        for (int i = 2; i <= n; i++) dp[1][i] = dp[1][i - 1] + grid[0][i - 1];

        //状态转移
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
