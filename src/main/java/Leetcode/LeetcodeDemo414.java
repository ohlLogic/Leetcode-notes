package com.Leetcode;

/**
 * Leetcode414,第三大的数
 *
 */

import java.util.Arrays;
public class LeetcodeDemo414 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums)
    {
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3) return nums[n - 1];

        int count = 1, index = n - 1;
        while(index > 0)
        {
            if(count == 3) return nums[index];
            if(nums[index] != nums[index - 1]) count++;
            index--;
        }
        if(count == 3) return nums[index];
        return nums[n - 1];
    }
}
