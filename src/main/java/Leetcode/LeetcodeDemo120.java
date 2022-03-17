package com.Leetcode;

/**
 * Leetcode120,三角形中最小路径和
 * 动态规划
 * dp[i][j]表示i，j坐标的最小路径和，自底向上
 * dp[i][j] = matrix[i][j] + min(dp[i+1][j],dp[i+1][j+1])
 * return dp[0][0]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo120 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) dp[n - 1][i] = triangle.get(n - 1).get(i);
        for(int i = n - 2; i >= 0; i--)
        {
            for(int j = 0; j <= i; j++)
            {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
