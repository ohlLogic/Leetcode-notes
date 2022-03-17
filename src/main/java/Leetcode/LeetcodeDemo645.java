package com.Leetcode;

/**
 * Leetcode645,错误的集合
 *
 */
public class LeetcodeDemo645 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        for (int errorNum : findErrorNums(nums)) {
            System.out.println(errorNum);
        }
    }

    public static int[] findErrorNums(int[] nums)
    {
        int n = nums.length;
        int[] temp = new int[n + 1];
        for(int i : nums) temp[i]++;
        int idx1 = 0, idx2 = 0;
        for(int i = 1; i <= n; i++)
        {
            if(temp[i] > 1) idx1 = i;
            if(temp[i] == 0) idx2 = i;
        }

        return new int[]{idx1, idx2};
    }
}
