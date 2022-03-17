package com.Leetcode;

/**
 * Leetcode162,寻找峰值
 * 二分：
 * 满足/不满足特性可以二分
 */
public class LeetcodeDemo162 {
    public static void main(String[] args) {

    }
    public static int findPeakElement(int[] nums)
    {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(nums[mid] > nums[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
