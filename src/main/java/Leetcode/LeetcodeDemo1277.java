package com.Leetcode;

/**
 * Leetcode1277,统计全为1的正方形子矩阵
 * 动态规划，同Leetcode221
 */
public class LeetcodeDemo1277 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1},{1, 1, 0}, {1, 1, 0}};
        System.out.println(countSquares(matrix));

    }

    public static int countSquares(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0)
                {
                    dp[i][j] = matrix[i][j];
                }
                else if(matrix[i][j] == 0) dp[i][j] = 0;
                else
                {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                res += dp[i][j];
            }

        }
        return res;
    }
}
