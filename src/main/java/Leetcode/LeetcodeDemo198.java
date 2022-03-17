package com.Leetcode;

/**
 * Leetcode198, 打家劫舍
 * 线性dp， dp[i]表示从开始到现在最大偷取金额数，那么当前状态可以从相邻的邻居过来(i-1)此时i就不能偷，也可以从
 * i-2过来此时就是dp[i - 2] + nums[i];
 * 初始状态：dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
 * 状态转移：dp[i] = max(num[i - 1], nums[i - 2] + nums[i])
 * return: dp[n - 1]
 */
public class LeetcodeDemo198 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
