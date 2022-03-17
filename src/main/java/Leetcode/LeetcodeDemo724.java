package com.Leetcode;

/**
 * Leetcode724,寻找数组的中心下标
 * 前缀和
 */
public class LeetcodeDemo724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];

        for(int i = 1; i <= n; i++)
        {
            int left = sum[i - 1], right = sum[n] - sum[i];
            if(left == right) return i - 1;
        }
        return -1;
    }
}
