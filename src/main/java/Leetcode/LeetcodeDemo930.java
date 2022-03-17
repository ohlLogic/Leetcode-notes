package com.Leetcode;

/**
 * Leetcode930,和相同的二元子数组
 *
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo930 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        System.out.println(numSubarrayWithSum(nums, 0));
    }

    //前缀和+哈希表
    public static int numSubarrayWithSum(int[] nums, int goal)
    {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        //为了讨论取到第一位的情况
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            int r = sum[i + 1], l = r - goal;
            res += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return res;
    }

    //滑动窗口(单调性)
    public static int numSubarrayWithSum1(int[] nums, int goal)
    {
        int n = nums.length;
        int res = 0;
        for(int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++)
        {
            s1 += nums[r];
            s2 += nums[r];
            while(l1 <= r && s1 > goal) s1 -= nums[l1++];
            while(l2 <= r && s2 >= goal) s2 -= nums[l2++];
            res += l2 - l1;
        }
        return res;
    }
}
