package com.Leetcode;

/**
 * Leetcode75,颜色分类
 * 快排，双指针
 */

import java.util.Arrays;


public class LeetcodeDemo75 {
    //快排
    public void sortColors(int[] nums)
    {
        Arrays.sort(nums);
    }

    //双指针
    public void sortColors1(int[] nums)
    {
        //循环不变量
        int n = nums.length;
        if(n < 2) return;

        /**
         * all in [0, zero) = 0
         * all in [zero, i) = 1
         * all in [two, n) = 2
         * 循环终止条件是i == two
         */

        int zero = 0, two = n;
        int i = 0;
        while(i < two)
        {
            if(nums[i] == 0)
            {
                swap(nums, i, zero);
                zero++;
                i++;
            }
            else if(nums[i] == 1) i++;
            else{
                two--;
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
