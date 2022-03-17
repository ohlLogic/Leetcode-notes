package com.Leetcode;

/**
 * Leetcode518,零钱兑换2
 * 动态规划
 */
public class LeetcodeDemo518 {
    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins)
    {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++)
        {
            int val = coins[i - 1];
            for(int j = val; j <= amount; j++)
            {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }
}
