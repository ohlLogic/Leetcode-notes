package com.Leetcode;

/**
 * Leetcode334,递增的三元子序列
 * 贪心
 */
public class LeetcodeDemo334 {
    //贪心
    public boolean increasingTriplet(int[] nums)
    {
        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int i : nums)
        {
            if(i > mid) return true;
            else if(i <= min) min = i;
            else mid = i;
        }
        return false;
    }
}
