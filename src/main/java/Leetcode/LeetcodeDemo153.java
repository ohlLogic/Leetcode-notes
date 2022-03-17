package com.Leetcode;

/**
 * Leetcode153,寻找旋转排序数组中的最小值
 * 二分：
 * 根据性质两端是否大于nums[0]进行二分
 */
public class LeetcodeDemo153
{
    public static void main(String[] args) {
        int[] nunms = {3, 4, 5, 1, 2};
        System.out.println(findMin(nunms));
    }
    public static int findMin(int[] nums)
    {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        return r < n - 1 ? nums[r + 1] : nums[0];
    }
}
