package com.Leetcode;

/**
 * Leetcode1446,连续字符
 */
public class LeetcodeDemo1446 {
    //动态规划
    public int maxPower(String s)
    {
        int n = s.length();

        //dp[i]表示以i结尾最长相同字符串
        int[] dp = new int[n];

        //初始化
        dp[0] = 1;

        int max = 1;
        //状态转移
        for(int i = 1; i < n; i++)
        {
            if(s.charAt(i) == s.charAt(i - 1)) dp[i] = dp[i - 1] + 1;
            else dp[i] = 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //双指针
    public int maxPower1(String s)
    {
        int n = s.length(), ans = 1;
        for(int i = 0; i < n; i++)
        {
            int j = i;
            while(j < n && s.charAt(i) == s.charAt(j)) j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }
}
