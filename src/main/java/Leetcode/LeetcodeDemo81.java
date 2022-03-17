package com.Leetcode;

/**
 * Leetcode81,索索旋转排序数组2
 * 二分
 *
 */
public class LeetcodeDemo81 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(search(nums, 0));
    }

    public static boolean search(int[] nums, int target)
    {
        int n = nums.length;
        int index = n - 1;
        for(int i = 0; i < n - 1; i++)
        {
            if(nums[i] > nums[i + 1])
            {
                index = i;
                break;
            }
        }
        int res = find(nums, 0, index, target);
        if(res != -1) return true;
        res = find(nums, index + 1, n - 1, target);
        if(res == -1) return false;
        return true;
    }

    public static int find(int[] nums, int l, int r, int target)
    {
        while(l < r)
        {
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        //判断是否越界
        if(l >= nums.length) return -1;
        return nums[l] == target ? l : -1;
    }
}
