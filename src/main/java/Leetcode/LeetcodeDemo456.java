package com.Leetcode;

/**
 * Leetcode456,132模式
 * 单调栈
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo456 {
    public boolean find132pattern(int[] nums)
    {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--)
        {
            if(nums[i] < k) return true;
            while(!d.isEmpty() && d.peekLast() < nums[i])
            {
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }
}
