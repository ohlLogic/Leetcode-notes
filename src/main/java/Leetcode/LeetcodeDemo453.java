package com.Leetcode;

/**
 * Leetcode453,最小操作数使数组元素相等
 */
public class LeetcodeDemo453 {
    public static void main(String[] args) {
        LeetcodeDemo453 tt = new LeetcodeDemo453();
        int[] nums = {1, 2, 3};
        System.out.println(tt.minMoves(nums));
    }

    public int minMoves(int[] nums)
    {
        int n = nums.length;
        int min = nums[0], sum = 0;
        for(int i : nums)
        {
            min = Math.min(min, i);
            sum += i;
        }
        return sum - min * n;
    }
}
