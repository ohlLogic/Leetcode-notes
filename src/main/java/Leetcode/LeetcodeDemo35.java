package com.Leetcode;

/**
 * Leetcode35, 搜索插入位置
 * 二分
 */
public class LeetcodeDemo35 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsert(nums, 0));
    }
    public static int searchInsert(int[] nums, int target)
    {
        int n = nums.length - 1;
        int l = 0, r = n;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l] >= target ? l : l + 1;
    }
}
