package com.Leetcode;

public class LeetcodeDemo91 {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
        System.out.println(numDecodings1(s));
    }

    /**
     * 动态规划
     * 定义dp[i]表示以i结尾字符串解码个数
     *
     * 初始状态
     * dp[0] = 1
     *
     * 状态转移
     *如果i位置字符合法，dp[i] = dp[i - 1]
     * 如果i位置和i - 1组成的位置合法，dp[i] = dp[i - 2]
     * 如果两种情况都满足，dp[i] = dp[i - 1]  + dp[i -2]
     */
    public static int numDecodings(String s)
    {
        int n = s.length();
        s = " " + s;
        int[] dp = new int[n + 1];

        //状态初始
        dp[0] = 1;
        for(int i = 1; i <= n; i++)
        {
            int a = s.charAt(i) - '0', b = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if(1 <= a && a <= 9) dp[i] += dp[i - 1];
            if(10 <= b && b <= 26) dp[i] += dp[i - 2];
        }
        return dp[n];
    }

    //空间优化，滚动数组
    public static int numDecodings1(String s)
    {
        int n = s.length();
        s = " " + s;
        int[] dp = new int[3];

        dp[0] = 1;
        for(int i = 1; i <= n; i++)
        {
            dp[i % 3] = 0;
            int a = s.charAt(i) - '0', b = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if(1 <= a && a <= 9) dp[i % 3] += dp[(i - 1) % 3];
            if(10 <= b && b <= 26) dp[i % 3] += dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }
}
