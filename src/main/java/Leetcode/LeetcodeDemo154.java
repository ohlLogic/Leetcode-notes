package com.Leetcode;

/**
 * Leetcode154,寻找旋转排序数组中的最小值2
 * 二分：
 * 本质是确定问题能够满足划分成两段的性质
 * 本题思路，去掉尾部与nums[0]相等的元素即可
 * 就可以保证两段，第一段>=nums[0]，第二段 < nums[0]
 */
public class LeetcodeDemo154 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums)
    {
        int n = nums.length;
        int l = 0, r = n - 1;

        //去除重复元素, l < r保证nums = {3,3,3}这种情况
        while(l < r && nums[0] == nums[r]) r--;

        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        return r < n - 1 ? nums[r + 1] : nums[0];
    }
}
