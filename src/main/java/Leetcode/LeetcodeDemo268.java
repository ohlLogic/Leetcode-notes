package com.Leetcode;

/**
 * Leetcode268,丢失的数字
 */
public class LeetcodeDemo268 {
    public int missingNumber(int[] nums)
    {
        int n = nums.length;
        int res = (n + 1) * n / 2;
        for(int num : nums) res -= num;
        return res;
    }
}
