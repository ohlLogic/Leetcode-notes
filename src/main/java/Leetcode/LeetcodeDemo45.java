package com.Leetcode;

/**
 * Leetcode45,跳跃游戏2
 *
 */
public class LeetcodeDemo45 {
    public static void main(String[] args) {
        int[] nums = {1,3,2,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int max = 0;
        int end = 0;
        int step = 0;
        for(int i = 0; i < n - 1; i++)
        {
            max = Math.max(max, i + nums[i]);
            if(i == end)
            {
                end = max;
                step++;
            }

        }
        return step;
    }
}

