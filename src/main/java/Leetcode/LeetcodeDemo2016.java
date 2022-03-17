package com.Leetcode;

/**
 * Leetcode2016,增量元素之间的最大差值
 * 模拟
 */
public class LeetcodeDemo2016 {
    public int maimumDifference(int[] nums)
    {
        int min = Integer.MAX_VALUE, ans = -1;
        for(int i : nums)
        {
            if(i < min)
            {
                min = i;
                continue;
            }
            int temp = i - min;
            if(temp > 0 && temp > ans) ans = temp;
        }
        return ans;
    }
}
