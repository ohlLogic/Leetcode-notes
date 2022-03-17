package com.Leetcode;

/**
 * Leetcode309,最佳买卖股票时机含冷冻期
 * 动态规划
 */


public class LeetcodeDemo309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit1(prices));
    }

    /**
     * 动态规划
     * dp[i][0]表示第i天结束后，持有股票最大收益
     * dp[i][1]表示第i天结束后，不持有股票并且不处于冷冻期最大收益
     * dp[i][2]表示第i天结束后，不持有股票并且处于冷冻期最大收益
     *
     * 初始状态：
     * dp[0][0] = -prices[0], dp[0][1] = 0, dp[0][2] = 0;
     *
     * 状态转移
     * dp[i][0]表示第i天后持有股票，那么可能来自i - 1天持有股票或者i-1天不持有股票，并且不处于冷冻期，第i天买入股票
     * dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])
     *
     * dp[i][1]表示第i天后不持有股票且不处于冷冻期，那么可能来自第i - 1天不持有股票但是处于冷冻期或者第i - 1天不持有也处于冷冻期
     * dp[i][1] = max(dp[i - 1][1], dp[i - 1][2])
     *
     * dp[i][2]表示第i天后不持有股票但是处于冷冻期
     * dp[i][2] = dp[i - 1][0] + prices[i]
     *
     * return max(dp[n - 1][1], dp[n - 1][2])
     */
    public static int maxProfit(int[] prices)
    {
        int n = prices.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][3];

        //状态初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        //状态转移
        for(int i = 1; i < n; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[n - 1][2], dp[n - 1][1]);
    }

    //空间优化
    public static int maxProfit1(int[] prices)
    {
        int n = prices.length;
        if(n == 0) return 0;

        int pre1 = -prices[0], pre2 = 0, pre3 = 0;
        for(int i = 1; i < n; i++)
        {
            int temp1 = pre1;
            pre1 = Math.max(pre1, pre2 - prices[i]);
            pre2 = Math.max(pre2, pre3);
            pre3 = temp1 + prices[i];
        }
        return Math.max(pre2, pre3);
    }
}
