package com.Leetcode;

/**
 * Leetcode375,猜数字大小2
 * 记忆化递归，区间dp
 */
public class LeetcodeDemo375 {
    int N = 210;
    int[][] cache = new int[N][N];
    public int getMoneyAmount(int n)
    {
        return dfs(1, n);
    }

    //区间[l, r]代表在范围内进行猜数，返回值至少需要多少钱
    int dfs(int l, int r)
    {
        if(l >= r) return 0;
        if(cache[l][r] != 0) return cache[l][r];

        int ans = 0x3f3f3f3f;
        for(int x = l; x <= r; x++)
        {
            //当选择的数位x时，至少需要cur 才能猜中数字
            int cur = Math.max(dfs(l, x - 1), dfs(x + 1, r)) + x;
            ans = Math.min(ans, cur);
        }
        cache[l][r] = ans;
        return ans;
    }

    //区间dp

    /**
     * dp[l][r]表示考虑在区间[l, r]进行猜数的最小成本
     * 假设本次选择的数值为x(l <= x <= r)，则有cur = max(dp[l][x-1], dp[x+1][r]) + x
     * @param n
     * @return
     */
    public int getMoneyAmount1(int n)
    {
        int[][] dp = new int[n + 10][n + 10];
        for(int len = 2; len <= n; len++)
        {
            for(int l = 1; l + len - 1 <= n; l++)
            {
                int r = l + len - 1;
                dp[l][r] = 0x3f3f3f3f;
                for(int x = l; x <= r; x++)
                {
                    int cur = Math.max(dp[l][x - 1], dp[x + 1][r]) + x;
                    dp[l][r] = Math.min(dp[l][r], cur);
                }
            }
        }
        return dp[1][n];
    }
}
