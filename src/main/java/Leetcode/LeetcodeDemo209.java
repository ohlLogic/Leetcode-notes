package com.Leetcode;

import java.util.Arrays;

/**
 * Leetcode209长度最小的子数组(可变滑动窗口模板)
 * 算法思想：
 * 1.初始化滑动窗口左右指针，l = 0, r = 0
 * 2.r指针向后扫描，直到滑动窗口内元素和sum >= target时，说明当前滑动窗口内满足情况
 * 此时考虑缩减滑动窗口大小，l指针向后移动，判断当前滑动窗口内sum是否满足条件，直到移动到不满足
 * 3.维护窗口内的最优解min，min = Math.min(min, r - l + 1)
 *
 */
public class LeetcodeDemo209 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums));
        System.out.println(minSubArrayLen1(11, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0, min = Integer.MAX_VALUE;

        while (r < nums.length) {
            sum += nums[r];

            while (sum >= target) {
                min = Math.min(min, r - l + 1);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static int minSubArrayLen1(int s, int nums[])
    {
        int min = Integer.MAX_VALUE;
        //前缀和数组求和
        int[] ss = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++)
        {
            ss[i] = ss[i - 1] + nums[i - 1];
        }

        for(int j = 0; j < nums.length; j++)
        {
            int target = s + ss[j];
            int index = Arrays.binarySearch(nums, target);
            if(index < 0) index = ~index;
            if(index <= nums.length) min = Math.min(min, index - j - 1);

        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
