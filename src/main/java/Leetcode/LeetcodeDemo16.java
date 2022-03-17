package com.Leetcode;

/**
 * Leetcode16,最接近的三数之和
 * 双指针
 */

import java.util.Arrays;

public class LeetcodeDemo16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target)
    {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for(int i = 0, j, k; i < nums.length; i++)
        {
            //排除重复情况
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            j = i + 1; k = nums.length - 1;
            while(j < k)
            {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - min) > Math.abs(target - sum)) min = sum;
                if(min == target) return target;
                else if(sum > target) k--;
                else if(sum < target) j++;
            }
        }
        return min;
    }
}
