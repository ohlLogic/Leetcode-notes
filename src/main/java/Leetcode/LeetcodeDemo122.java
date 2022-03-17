package com.Leetcode;

/**
 * Leetcode122,买卖股票的最佳时机2
 */
public class LeetcodeDemo122 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(prices));
    }

    //动态规划
    public static int maxProfit(int[] prices)
    {
        int n = prices.length;
        int[][] dp = new int[n][2];

        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < n; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //优化空间，滚动数组
    public static int maxProfit1(int[] prices)
    {
        int n = prices.length, pre1 = 0, pre2 = -prices[0];
        for(int i = 1; i < n; i++)
        {
            int temp = pre1;
            pre1 = Math.max(pre1, pre2 + prices[i]);
            pre2 = Math.max(pre2, temp - prices[i]);
        }
        return pre1;
    }

    //贪心
    public static int maxProfit2(int[] prices)
    {
        int n = prices.length, sum = 0;
        for(int i = 1; i < n; i++)
        {
            sum += prices[i] - prices[i - 1] > 0 ? prices[i] - prices[i - 1] : 0;
        }
        return sum;
    }
}
