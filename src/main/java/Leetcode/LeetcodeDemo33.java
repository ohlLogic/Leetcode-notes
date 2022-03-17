package com.Leetcode;

/**
 * Leetcode33,搜索旋转排序数组
 * 二分
 */
public class LeetcodeDemo33 {
    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(search(nums, 1));
    }

    public static int search(int[] nums, int target)
    {
        int r1 = 0, n = nums.length;
        for(int i = 1 ; i < n; i++)
        {
            if(nums[i - 1] > nums[i])
            {
                r1 = i;
                break;
            }
        }
        int res = find(nums, 0, r1 - 1, target);
        if(res != -1) return res;
        if(r1 < n) res = find(nums, r1, n - 1, target);
        return res;

    }
    public static int find(int[] nums, int l, int r, int target)
    {
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(nums[mid] <=  target) l = mid;
            else r = mid - 1;
        }
        return nums[l] == target ? l : -1;
    }
}
