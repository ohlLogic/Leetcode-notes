package com.Leetcode;

/**
 * Leetcode416,分割等和子集
 * 动态规划
 *
 */
public class LeetcodeDemo416 {
    public boolean canPartition(int[] nums)
    {
        int n = nums.length;

        //等价和子集是总和的一半
        int sum = 0;
        for(int i : nums) sum += i;
        int target = sum / 2;

        if(target * 2 != sum) return false;

        int[][] dp = new int[n][target + 1];
        //只考虑第1件物品的情况
        for(int j = 0; j <= target; j++)
        {
            dp[0][j] = j >= nums[0] ? nums[0] : 0;
        }

        //考虑其他物品的情况
        for(int i = 1; i < n; i++)
        {
            int t = nums[i];
            for(int j = 0; j <= target; j++)
            {
                //不选第i件物品
                int no = dp[i - 1][j];
                //选择第i件物品
                int yes = j >= t ? dp[i - 1][j - t] + t : 0;
                dp[i][j] = Math.max(no, yes);
            }
        }

        return dp[n - 1][target] == target;
    }
}
