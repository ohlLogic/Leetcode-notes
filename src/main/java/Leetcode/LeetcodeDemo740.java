package com.Leetcode;

import static com.Leetcode.LeetcodeDemo198.rob;


/**
 * Leetcode740, 删除并获得点数(动态规划)
 * 假设 x= nums[i], 那么 x -1, x + 1,也需要删除;换句话说，也就是相邻的需要删除，类比
 * Leetcode198打家劫舍，就是不能选择相邻的。
 *
 */
public class LeetcodeDemo740 {
    public static void main(String[] args) {
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums)
    {
        int maxval = 0;
        for(int num : nums) maxval = Math.max(num, maxval);

        int[] sum = new int[maxval + 1];
        for(int val : nums) sum[val] += val;

        return rob(sum);
    }
}
