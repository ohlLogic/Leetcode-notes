package com.Leetcode;

import static com.Leetcode.LeetcodeDemo53.maxSubArray1;

/**
 * Leetcode918,环形子数组的最大和
 * 动态规划
 * 分两种情况：
 * 第一种情况，子序列和的最大值在原数组部分，情况和Leetcode53做法一样；
 * 第二种情况，子序列和的最大值在数组两端取到，那么中间部分就是最小序列和，用sum - min即可；
 * 最后，如果数组全为负数，那么此时min == sum
 * 返回 sum - min == 0 ? max(nums) : max(max(nums), sum - min)
 */
public class LeetcodeDemo918 {
    public static void main(String[] args) {
        int[] nums = {-2, -3, -1};
        System.out.println(maxSubarrayCricular(nums));
    }

    public static int maxSubarrayCricular(int[] nums) {
        int n = nums.length;
        int pre = nums[0], min = pre;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for(int i = 1; i < n; i++)
        {
            pre = Math.min(pre + nums[i], nums[i]);
            min = Math.min(pre, min);
        }
        return sum - min == 0 ? maxSubArray1(nums) : Math.max(maxSubArray1(nums), sum - min);


    }
}