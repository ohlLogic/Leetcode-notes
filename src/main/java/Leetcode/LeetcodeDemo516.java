package com.Leetcode;

public class LeetcodeDemo516 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public static int longestPalindromeSubseq(String s)
    {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i--)
        {
            dp[i][i] = 1;
            char l = s.charAt(i);
            for(int j = i + 1; j < n; j++)
            {
                char r = s.charAt(j);
                if(l == r) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}
