package com.Leetcode;

/**
 * Leetcode376,摆动序列
 * 动态规划
 * 定义
 * up[i]表示以i结尾上升的摆动序列
 * down[i]表示以i结尾下降的摆动序列
 *
 * 初始状态：
 * up[0] = 1, down[0] = 1;
 *
 * 状态转移：
 *
 * if nums[i] > nums[i - 1]
 * up[i] = max(up[i - 1], down[i - 1] + 1)
 * down[i] = down[i - 1]
 *
 * if nums[i] < nums[i -1]
 * down[i] = max(down[i - 1], up[i - 1] + 1)
 * up[i] = up[i - 1];
 *
 * if nums[i] == nums[i - 1]
 * up[i] = up[i - 1]
 * down[i] = down[i - 1]
 */
public class LeetcodeDemo376 {
    public static void main(String[] args) {
        int[] nums = {84};
        System.out.println(wiggleMaxLength(nums));
    }
    public static int wiggleMaxLength(int[] nums)
    {
        int n = nums.length;
        if(n == 0) return 0;

        int[] dp = new int[n];
        int[] sub = new int[n];
        for(int i = 1; i < n; i++) sub[i] = nums[i] - nums[i - 1];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < n; i++)
        {
            //表示相邻两个数字相等
            if(sub[i] == 0) dp[i] = 1;
            else dp[i] = 2;
            for(int j = 0; j < i; j++)
            {
                if(sub[i] * sub[j] < 0) dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }

    public static int wiggleMaxLength1(int[] nums)
    {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1, down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = Math.max(up, down + 1);
            } else if (nums[i] < nums[i - 1]) {
                down = Math.max(up + 1, down);
            }
        }
        return Math.max(up, down);
    }
}
