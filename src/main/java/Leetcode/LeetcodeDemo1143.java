package com.Leetcode;

/**
 * Leetcode1143,最长公共子序列
 * 动态规划
 * dp[i][j]表示text1以i结尾的子序列和text2以j结尾的子序列的最长公共序列长度(不一定含当前位置)
 *
 * 初始状态
 * i == 0 || j == 0
 * dp = 0
 *
 * 状态转移
 * if text1[i] = text2[j]
 * dp[i][j]=dp[i-1][j-1] + 1
 *
 * else
 * dp[i][j] = max(dp[i-1][j],dp[i][j-1])
 *
 */
public class LeetcodeDemo1143 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("bl", "yby"));
    }
    public static int longestSubsequence(String text1, String text2)
    {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];

    }
}
