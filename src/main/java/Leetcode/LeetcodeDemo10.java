package com.Leetcode;

/**
 * Leetcode10,正则表达匹配
 * 动态规划
 */
public class LeetcodeDemo10 {
    public static void main(String[] args) {
        LeetcodeDemo10 tt = new LeetcodeDemo10();
        System.out.println(tt.isMatch("aa", "a"));
    }
    public boolean isMatch(String s, String p)
    {
        int n = s.length(), m = p.length();
        //字符串前面插入空格，那么char数组是从1开始
        s = " " + s;
        p = " " + p;

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        //dp[i][j]表示s[1,...,i]与p[1,...,j]是否匹配
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for(int i = 0; i <= n; i++)
        {
            for(int j = 1; j <= m; j++)
            {
                //如果下一个字符是*,则代表当前字符不能被单独使用，跳过
                if(j + 1 <= m && pp[j + 1] == '*') continue;

                //p[j]为普通字符或者.
                if(i - 1 >= 0 && pp[j] != '*') dp[i][j] = dp[i - 1][j - 1] && (ss[i] == pp[j] || pp[j] == '.');

                //对应p[j]为*
                else if(pp[j] == '*')
                    dp[i][j] = (j - 2 >= 0 && dp[i][j - 2] || (i - 1 >= 0 && dp[i - 1][j] && (ss[i] == pp[j - 1] || pp[j - 1] == '.')));
            }
        }
        return dp[n][m];
    }
}
