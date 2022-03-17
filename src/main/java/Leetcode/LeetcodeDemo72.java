package com.Leetcode;

/**
 * Leetcode72,编辑距离
 * 动态规划
 *
 */
public class LeetcodeDemo72 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2)
    {
        int n = word1.length(), m = word2.length();

        int[][] dp =  new int[n + 1][m + 1];

        //初始状态
        for(int i = 1; i <= n; i++) dp[i][0] = i;
        for(int j = 1; j <= m; j++) dp[0][j] = j;

        //状态转移
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }

        return dp[n][m];
    }
}
