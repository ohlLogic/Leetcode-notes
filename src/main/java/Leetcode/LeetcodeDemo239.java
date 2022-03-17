package com.Leetcode;

/**
 * Leetcode239,滑动窗口中的最大值
 * 优先队列，单调队列
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class LeetcodeDemo239 {
    //优先队列(TLE)
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> d = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0, idx = 0; i < n; i++)
        {
            d.add(nums[i]);
            if(i < k - 1) continue;
            res[idx++] = d.peek();
            d.remove(nums[i - k + 1]);
        }
        return res;
    }

    //单调队列
    public int[] maxSlidingWindow1(int[] nums, int k)
    {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> d = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            //保持从队头到队尾下标对应的元素递减，那么队头一定就是滑动窗口中最大的元素
            while(!d.isEmpty() && nums[i] >= nums[d.peekLast()]) d.pollLast();
            d.addLast(i);
            if(i < k - 1) continue;
            //检车队头元素下标是否已经超过滑动窗口
            while(d.peekFirst() <= i - k) d.pollFirst();
            res[i - k + 1] = nums[d.peekFirst()];
        }
        return res;
    }
}
