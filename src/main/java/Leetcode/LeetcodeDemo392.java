package com.Leetcode;

/**
 * Leetcode392，判断子序列
 * 双指针
 *
 */
public class LeetcodeDemo392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("", "ahbgdc"));
        System.out.println(isSubsequence1("", "ahbgdc"));
    }
    public static boolean isSubsequence(String s, String t)
    {
        if(s.length() == 0) return true;
        if(t.length() == 0) return false;
        int i = 0, j = 0;
        while(j < t.length())
        {
            if(s.charAt(i) == t.charAt(j)) i++;
            if(i == s.length()) return true;
            j++;
        }

        return false;
    }

    /**
     * 动态规划
     * 定义dp[i][j]表示s字符串中第i个位置，t字符串第j个位置相同子序列的长度和
     *
     *初始状态
     * dp[0][0]= 0 , dp[i][0]=0
     *
     * 状态转移
     * if
     *
     *
     */

    public static boolean isSubsequence1(String s, String t)
    {
        int n = s.length(), m = t.length();

        int[][] dp = new int[n + 1][m + 1];
        for(int i =  1; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                if(s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = dp[i][j - 1];
            }
        }
        if(dp[n][m] == n) return true;
        else return false;

    }
}
