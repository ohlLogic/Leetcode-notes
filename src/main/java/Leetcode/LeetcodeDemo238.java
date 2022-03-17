package com.Leetcode;

/**
 * Leetcode,238除自身之外数组的乘积
 */
public class LeetcodeDemo238 {
    //左右数组
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];

        /**
         * 初始化
         * left数组第一个位置为1，right数组最后一个位置为1
         */
        left[0] = 1;
        right[n - 1] = 1;
        /**
         * left[i] = left[i - 1] * nums[i - 1];
         * right[i] = right[i + 1] * nums[i + 1];
         */

        for(int i = 1; i < n; i++) left[i] = left[i - 1] * nums[i - 1];
        for(int i = n - 2; i >= 0; i--) right[i] = right[i + 1] * nums[i + 1];

        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = left[i] * right[i];
        return res;
    }

    //对return数组进行原地构造
    public int[] productExceptSelf1(int[] nums)
    {
        int n = nums.length;
        int[] res = new int[n];

        //对res数组进行左乘积数组
        res[0] = 1;
        for(int i = 1; i < n; i++) res[i] = res[i - 1] * nums[i - 1];

        //对res数组进行右构造
        for(int i = n - 1, R = 1; i >= 0; i--)
        {
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }
}
