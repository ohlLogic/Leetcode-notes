package com.Leetcode;

/**
 * Leetcode561,数组拆分1
 * 贪心
 */

import java.util.Arrays;

public class LeetcodeDemo561 {
    public int arrayPairSum(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < n; i += 2)
        {
            sum += nums[i];
        }
        return sum;
    }
}
