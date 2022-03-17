package com.Leetcode;

/**
 * Leetcode647,回文子串
 */
public class LeetcodeDemo647 {
    /**
     * 动态规划：dp[i][j]表示字符串s[l,...,r]是否为回文串
     *
     * 初始状态： dp数组初始化为false
     *
     * 状态转移：
     * 如果s[i] != s[j]，dp[i][j] = false
     * 如果s[i] == s[j]：
     * 如果 i == j， 那么是回文串；如果j - i == 1, 那么是回文串
     * 如果j - i > 1, 那么dp[i][j] = dp[i + 1][j - 1]
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s)
    {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int ans = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = i; j < n; j++)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    if(j - i <= 1)
                    {
                        ans++;
                        dp[i][j] = true;
                    }
                    else if(dp[i + 1][j - 1])
                    {
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }

    //中心扩展法
    public int countSubstrings1(String s)
    {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < 2 * n - 1; i++)
        {
            int left = i / 2, right = left + i % 2;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right))
            {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
