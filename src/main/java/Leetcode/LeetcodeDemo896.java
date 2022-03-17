package com.Leetcode;

/**
 * Leetcode896,单调数列
 *
 */
public class LeetcodeDemo896 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums)
    {
        int n = nums.length;
        boolean up = nums[n - 1] - nums[0] >= 0 ? true : false;
        for(int i = 1; i < n; i++)
        {
            if(up)
            {
                if(nums[i] - nums[i - 1] < 0) return false;
            }
            else
            {
                if(nums[i] - nums[i - 1] > 0) return false;
            }
        }
        return true;
    }

    public static boolean isMonotonic1(int[] nums)
    {
        boolean up = true, down = true;
        for(int i = 0; i < nums.length - 1; i++)
        {
            if(nums[i] > nums[i + 1]) up = false;
            if(nums[i] < nums[i + 1]) down = false;
            if(!up && !down) return false;
        }
        return up || down;
    }
}
