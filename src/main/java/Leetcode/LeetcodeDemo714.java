package com.Leetcode;

/**
 * Leetcode714,买卖股票的最佳时机含手续费
 */
public class LeetcodeDemo714 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit1(nums, 2));
    }

    /**
     * 动态规划
     * dp[i][0]表示第i天结束后不持有股票最大收益，dp[i][1]表示第i天结束后持有股票最大收益
     *
     * 初始状态
     * dp[0][0] = 0, dp[0][1] = - prices[0]
     *
     * 状态转移
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee)
     * dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
     *
     * return dp[n - 1][0]
     */
    public static int maxProfit(int[] prices, int fee)
    {
        int n = prices.length;
        if(n == 0) return 0;

        int[][] dp = new int[n][2];

        //状态初始
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //空间优化
    public static int maxProfit1(int[] prices, int fee)
    {
        int n = prices.length;
        if(n == 0) return 0;

        int pre1 = 0, pre2 = -prices[0];
        for(int i = 1; i < n; i++)
        {
            int temp = pre1;
            pre1 = Math.max(pre1, pre2 + prices[i] - fee);
            pre2 = Math.max(pre2, temp - prices[i]);
        }
        return pre1;
    }
}
