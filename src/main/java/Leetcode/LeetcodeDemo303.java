package com.Leetcode;

/**
 * Leetcode303,区域和检索
 * 一维前缀和
 */
public class LeetcodeDemo303 {
    public static void main(String[] args) {

    }
    int[] temp;
    public LeetcodeDemo303(int[] nums)
    {
        int n = nums.length;
        temp = new int[n + 1];
        for(int i = 1; i <= n; i++) temp[i] = temp[i - 1] + nums[i - 1];
    }

    public int sumRange(int left, int right)
    {
        return temp[right + 1] - temp[left];
    }
}
