package com.Leetcode;

public class LeetcodeDemo121 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit2(prices));
    }

    //暴力法
    public static int maxProfit(int[] prices) {
        int max = 0, n = prices.length;
        for (int i = 0; i < n - 1; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(prices[j] - prices[i] > max) max = prices[j] - prices[i];
            }
        }
        return max;
    }

    /**
     * 动态规划
     * dp[i]表示截止到i价格最低是多少;
     * max用来维护最大值
     */
    public static int maxProfit1(int[] prices)
    {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for(int i = 1; i < prices.length; i++)
        {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            max = Math.max(prices[i] - dp[i], max);
        }
        return max;
    }


    //优化空间复杂度，用pre记录最小值即可
    public static int maxProfit2(int[] prices)
    {
        int max = 0;
        int pre = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++)
        {
            pre = Math.min(pre, prices[i]);
            max = Math.max(prices[i] - pre, max);
        }
        return max;
    }
}
