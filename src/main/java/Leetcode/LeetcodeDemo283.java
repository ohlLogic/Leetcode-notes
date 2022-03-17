package com.Leetcode;

/**
 * LeetcodeDemo283,移动零
 * 双指针
 */
public class LeetcodeDemo283 {
    public void moveZeroes(int[] nums)
    {
        int n = nums.length;
        int left = 0, right = 0;
        while(right < n)
        {
            if(nums[right] != 0)
            {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int l, int r)
    {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
