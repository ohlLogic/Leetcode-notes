package com.Leetcode;

/**
 * Leetcode34,在排序数组中查找元素的第一个和最后一个位置
 * 二分
 */
public class LeetcodeDemo34 {
    public static void main(String[] args) {
        int[] nums = {2, 2};
        int[] res = searchRange(nums, 2);
        for (int re : res) {
            System.out.println(re);
        }

    }

    public static int[] searchRange(int[] nums, int target)
    {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;

        int l = 0, r = nums.length - 1;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        if(nums[l] != target) return res;
        res[1] = l;
        int index = l;
        for(int i = l - 1; i >= 0; i--)
        {
            if(target == nums[i]) index = i;
        }
        res[0] = index;
        return res;
    }
}
