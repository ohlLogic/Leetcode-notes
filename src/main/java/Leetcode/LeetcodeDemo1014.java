package com.Leetcode;

/**
 * Leetcode1014，最佳观光组合
 * 题目定义values[i] + values[j] + j - i为得分，使用j遍历每个景点那么对于每个景点而言
 * values[j] + j的值是固定的，要使总得分最大，只需要使得values[i] - i最大即可
 * 定义mx = max(mx, values[i] - i)
 */
public class LeetcodeDemo1014 {
    public static void main(String[] args) {
        int[] nums = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(nums));
    }

    public static int maxScoreSightseeingPair(int[] values)
    {
        int n = values.length;
        int max = 0, mx = values[0] + 0;
        for(int j = 1; j < n; j++)
        {
            max = Math.max(max, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return max;

    }
}
