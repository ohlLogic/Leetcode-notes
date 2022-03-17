package com.Leetcode;

/**
 * Leetcode713,乘积小于K的子数组
 * 滑动窗口
 */
public class LeetcodeDemo713 {
    public int numSubarrayProductLessThanK(int[] nums, int k)
    {
        if(k <= 1) return 0;
        int ans = 0, n = nums.length;
        int l = 0, r = 0, base = 1;
        while(r < n)
        {
            base *= nums[r];
            while(base >= k) base /= nums[l++];
            ans += r - l + 1;
            r++;
        }
        return ans;
    }
}
