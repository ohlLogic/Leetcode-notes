package com.Leetcode;

/**
 * Leetcode413,等差数列拆分
 */
public class LeetcodeDemo413 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(numberOfArithmetcSlices(nums));
        System.out.println(numberOfArithmetcSlices1(nums));
    }

    /**
     * 动态规划
     * dp[i]表示nums[0,...,i]子数组等差数列的数量
     *
     * 初始状态
     * dp[0] = 0, dp[1] = 0
     *
     * 状态转移
     * if nums[i] - nums[i - 1]==nums[i -1] - nums[i -2] 是等差数列
     * dp[i] = dp[i - 1] + 1
     * else 0
     * return res += dp[i]
     */
    public static int numberOfArithmetcSlices(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;

        //初始状态
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i < n; i++)
        {
            if(nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2])
            {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }else dp[i] = 0;
        }
        return res;
    }

    //双指针
    public static int numberOfArithmetcSlices1(int[] nums)
    {
        int n = nums.length;
        int res = 0;

        for(int i = 0; i < n - 2; i++)
        {
            int j = i, d = nums[i + 1] - nums[i];
            while(j < n - 1 && nums[j + 1] - nums[j] == d) j++;
            int len = j - i + 1;
            int a1 = 1, an = len - 3 + 1;
            int cnt = (a1 + an) * an /2;
            res += cnt;
            i = j;
        }
        return res;
    }
}
