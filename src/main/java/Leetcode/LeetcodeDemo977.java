package com.Leetcode;

/**
 * Leetcode977,有序数组的平方
 * 双指针
 */
public class LeetcodeDemo977 {
    public int[] sortedSquares(int[] nums)
    {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        int idx = n - 1;
        while(l <= r)
        {
            int left = nums[l] * nums[l], right = nums[r] * nums[r];
            if(left < right) {
                res[idx--] = right;
                r--;
            }
            else {
                res[idx--] = left;
                l++;
            }
        }
        return res;
    }
}
