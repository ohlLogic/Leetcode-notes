package com.Leetcode;

/**
 * Leetcode377,组合总数2
 * 动态规划
 */
public class LeetcodeDemo377 {
    public static void main(String[] args) {

    }

    public int combinationSum4(int[] nums, int target)
    {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int j = 1; j <= target; j++)
        {
            for(int u : nums)
            {
                if(j >= u) dp[j] += dp[j - u];
            }
        }
        return dp[target];
    }
}
