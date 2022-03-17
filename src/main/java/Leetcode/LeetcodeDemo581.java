package com.Leetcode;

/**
 * Leetcode581,最短无序连续子数组
 * 双指针
 */

import java.util.Arrays;

public class LeetcodeDemo581 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(findUnsortedSubarray(nums));
        System.out.println(findUnsortedSubarray1(nums));
    }

    //双指针+排序
    public static int findUnsortedSubarray(int[] nums)
    {
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        while(l <= r && nums[l] == arr[l]) l++;
        while(l <= r && nums[r] == arr[r]) r--;
        return r - l + 1;
    }

    //双指针 线性扫描
    public static int findUnsortedSubarray1(int[] nums)
    {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int l = 0, r = -1;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] < max) r = i;
            else max = nums[i];

            if(nums[n - 1 - i] > min) l = n - 1 - i;
            else min = nums[n - 1 - i];
        }
        return r - l + 1;
    }
}
