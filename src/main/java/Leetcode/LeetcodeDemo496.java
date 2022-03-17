package com.Leetcode;

/**
 * Leetcode496,下一个更大的元素1
 * 单调栈
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo496 {
    //单调栈
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = m - 1; i >= 0; i--)
        {
            int x = nums2[i];
            while(!d.isEmpty() && d.peekLast() <= x) d.pollLast();
            map.put(x, d.isEmpty() ? -1 : d.peekLast());
            d.addLast(x);
        }

        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = map.get(nums1[i]);
        return res;
    }
}
