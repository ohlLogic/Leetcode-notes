package com.Leetcode;

/**
 * Leetcode167,两数之和2输入有序数组
 * 双指针
 */
public class LeetcodeDemo167 {
    public int[] twoSum(int[] numbers, int target)
    {
        int n = numbers.length;
        int l = 0, r = n - 1, sum = 0;
        while(l < r)
        {
            sum = numbers[l] + numbers[r];
            if(sum == target) return new int[]{l + 1, r + 1};
            else if(sum > target) r--;
            else l++;
        }
        return new int[]{-1, -1};
    }
}
