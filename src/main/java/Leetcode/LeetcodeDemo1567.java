package com.Leetcode;

/**
 * Leetcode1567,乘积为正数的最长子数组长度
 * 动态规划：
 * 定义两个数组，positive,negative
 * 其中positive[i]表示以i结束乘积为正数的最长子数组的长度，negative[i]表示以i结束乘积为负数的最长子数组的长度
 * 初始状态：如果nums[0] > 0, positive[0] = 1;如果nums[0] < 0, negative[0] = 1;
 * 状态转移：
 * 如果当前的nums[i] > 0, 那么positive[i] = positive[i - 1] + 1, negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0
 * 如果当前的nums[i] < 0, 那么positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0, negative[i] = positive[i - 1] + 1;
 * 如果当前的nums[i] == 0, 那么positive[i] = 0, negative[i] = 0
 * 使用max记录positive数组的最大值即可
 */
public class LeetcodeDemo1567 {
    public static void main(String[] args) {
        int[] nums = {1,-2,-3,4};
        System.out.println(getMaxLen1(nums));
    }

    //动态规划
    public static int getMaxLen(int[] nums)
    {
        int n = nums.length;
        int[] positive = new int[n];
        int[] negative = new int[n];
        if(nums[0] < 0) negative[0] = 1;
        if(nums[0] > 0) positive[0] = 1;

        int max = positive[0];
        for(int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                if (negative[i - 1] > 0) negative[i] = negative[i - 1] + 1;
                if (negative[i - 1] == 0) negative[i] = 0;
            } else if (nums[i] < 0) {
                if (negative[i - 1] > 0) positive[i] = negative[i - 1] + 1;
                if (negative[i - 1] == 0) positive[i] = 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            max = Math.max(max, positive[i]);
        }
        return max;
    }

    //滚动数组优化空间
    public static int getMaxLen1(int[] nums)
    {
        int n = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int max = positive;
        for(int i = 1; i < n; i++)
        {
            if(nums[i] > 0)
            {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            }
            else if(nums[i] < 0)
            {
                int temp = positive;
                positive = negative > 0 ? negative + 1 : 0;
                negative = temp + 1;
            }else{
                positive = 0;
                negative = 0;
            }
            max =  Math.max(max, positive);
        }
        return max;
    }
}
