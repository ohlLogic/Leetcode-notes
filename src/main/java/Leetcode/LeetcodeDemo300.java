package com.Leetcode;

/**
 * Leetcode300,最长递增子序列
 * 动态规划
 * dp[i]表示以数组第i个结尾数组的最长子序列
 * 初始化，以每个数组结尾的数组的最长子序列均为1
 *
 * 状态转移：
 * if nums[i] > nums[j]，那么dp[i] = max(dp[i], dp[j] + 1)
 */
public class LeetcodeDemo300 {
    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];

        int max = 1;

        //初始状态
        dp[0] = 1;
        for(int i = 1; i < n; i++)
        {
            dp[i] = 1;
            for(int j = 0; j < i; j++)
            {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
