package com.Leetcode;

/**
 * Leetcode1646,获取生成数组中的最大值
 *
 */
public class LeetcodeDemo1646 {
    public static void main(String[] args)
    {
        System.out.println(getMaximumGenerated(3));
    }

    public static int getMaximumGenerated(int n)
    {
        int[] nums = new int[n + 1];
        if(n == 0) return 0;
        nums[0] = 0;
        nums[1] = 1;
        int max = nums[0] >= nums[1] ? nums[0] : nums[1];
        for(int i = 2; i <= n; i++)
        {
            if(i % 2 == 0) nums[i] = nums[i / 2];
            else nums[i] = nums[i / 2] + nums[(i + 1) / 2];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
