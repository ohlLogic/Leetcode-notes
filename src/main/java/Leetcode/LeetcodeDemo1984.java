package com.Leetcode;

/**
 * Leetcode1984,学生分数的最小差值
 * 排序 + 滑动窗口
 */

import java.util.Arrays;

public class LeetcodeDemo1984 {
    public int mininumDifference(int[] nums, int k)
    {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;
        while(r < nums.length)
        {
            if(r - l + 1 == k) {
                ans = Math.min(ans, nums[r] - nums[l]);
                l++;
            }
            r++;
        }
        return ans;
    }
}
