package com.Leetcode;

/**
 * Leetcode553,最优除法
 * 贪心
 */
public class LeetcodeDemo553 {
    public String optimalDivision(int[] nums)
    {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            sb.append(nums[i]);
            if(i + 1 < n) sb.append("/");
        }

        if(n > 2)
        {
            sb.insert(sb.indexOf("/") + 1, "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
