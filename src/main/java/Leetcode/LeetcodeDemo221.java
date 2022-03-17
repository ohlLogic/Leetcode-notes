package com.Leetcode;

/**
 * Leetcode221,最大正方形
 * 动态规划
 * dp[i][j]表示以i,j坐标结束的正方形最大个数
 * 状态转移：
 * if matrix[i][j] != '0'
 * dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1;
 * if matrix[i][j] == '0'
 * dp[i][j]=0
 */
public class LeetcodeDemo221 {
    public static void main(String[] args) {
        char[][] mat = {{'0'}};
        System.out.println(maximalSquare(mat));
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int max = 0;
        //初始状态
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }


        //状态转移
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }


    return max * max;
    }
}
