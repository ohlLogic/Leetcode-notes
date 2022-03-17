package com.Leetcode;

/**
 * Leetcode97，交错字符串
 * 动态规划
 *
 */
public class LeetcodeDemo97 {
    //动态规划
    public boolean isInterleave(String s1, String s2, String s3)
    {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if(n + m != t) return false;

        //dp[i][j]表示s3的前i + j个元素能否由s1的前i个元素和s2的前j个元素构成
        boolean[][] dp = new boolean[n + 1][m + 1];

        //状态初始化
        dp[0][0] = true;
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= m; j++)
            {
                int p = i + j - 1;
                //包含了初始化dp[0][j] = false, dp[i][0] = false
                if(i > 0) dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                if(j > 0) dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return dp[n][m];
    }

    //动态规划 + 滚动数组
    public boolean isInterleave1(String s1, String s2, String s3)
    {
        int n = s1.length(), m = s2.length(), t = s3.length();
        if(n + m !=  t) return false;

        //滚动数组,因此dp[i][j]只与上一层的dp[i - 1][j]和当前层的dp[i][j - 1]有关
        boolean[] dp = new boolean[m + 1];

        dp[0] = true;
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= m; j++)
            {
                int p = i + j - 1;
                if(i > 0) dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                if(j > 0) dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
            }
        }
        return dp[m];
    }
}
