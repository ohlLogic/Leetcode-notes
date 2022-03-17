package com.Leetcode;

/**
 * Leetcode152,乘积最大子数组
 * 动态规划
 */
public class LeetcodeDemo152 {
    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        System.out.println(maxProduct1(nums));
    }

    public static int maxProduct(int[] nums)
    {
        int n = nums.length;
        int[] dp1 = new int[n + 1];
        int[] dp2 = new int[n + 1];

        int max = nums[0];
        //状态初始化
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        for(int i = 1; i < n; i++)
        {
            dp1[i] = Math.max(Math.max(dp1[i - 1] * nums[i], nums[i]), dp2[i - 1] * nums[i]);
            dp2[i] = Math.min(Math.min(dp1[i - 1] * nums[i], nums[i]), dp2[i - 1] * nums[i]);
            max = Math.max(max, dp1[i]);
        }

        return max;
    }

    //空间复杂度优化，设置pre1， pre2
    public static int maxProduct1(int[] nums)
    {
        int n = nums.length;
        int max = nums[0];
        int pre1 = nums[0], pre2 = nums[0], temp;
        for(int i = 1; i < n; i++)
        {
            temp = pre1;
            pre1 = Math.max(Math.max(pre1 * nums[i], nums[i]), pre2 * nums[i]);
            pre2 = Math.min(Math.min(temp * nums[i], nums[i]), pre2 * nums[i]);
            max = Math.max(pre1, max);
        }
        return max;
    }

}
