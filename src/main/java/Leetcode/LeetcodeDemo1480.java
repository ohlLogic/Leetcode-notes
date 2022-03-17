package com.Leetcode;

/**
 * Leetcode1480,一维数组的动态和
 * 一维前缀数组
 */
public class LeetcodeDemo1480 {
    public static void main(String[] args) {

    }

    public static int[] runningSum(int[] nums)
    {
        int n = nums.length;
        for(int i = 1; i < n; i++) nums[i] += nums[i - 1];
        return nums;
    }
}
