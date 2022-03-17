package com.Leetcode;

/**
 * Leetcode1438,绝对不超过限制的最长连续子数组
 * 滑动窗口
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class LeetcodeDemo1438 {
    public static void main(String[] args) {

    }
    //二分+滑动窗口
    public static int longestSubarray(int[] nums, int limit)
    {
        int n = nums.length;
        int l = 1, r = n;
        while(l < r)
        {
            int mid = l + r + 1 >> 1;
            if(check(nums, mid, limit)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    public static boolean check(int[] nums, int len, int limit)
    {
        int n = nums.length;
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        for(int r = 0, l = r - len + 1; r < n; r++, l = r - len + 1)
        {
            if(!max.isEmpty() && max.peekFirst() < l) max.pollFirst();
            while(!max.isEmpty() && nums[r] >= nums[max.peekLast()]) max.pollLast();
            max.addLast(r);
            if(!min.isEmpty() && min.peekFirst() < l) min.pollFirst();
            while(!min.isEmpty() && nums[r] <= nums[min.peekLast()]) min.pollLast();
            min.addLast(r);
            if(l >= 0 && Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) <= limit) return true;
        }
        return false;
    }


    //滑动窗口,TreeMap维护区间的最大值和最小值
    public static int longestSubarray1(int[] nums, int limit)
    {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0, r = 0;
        int res = 0;
        while(r < n)
        {
            //滑动窗口向右扩张
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            //如果滑动窗口中最大值和最小值相减>limit，此时考虑收缩滑动窗口的左区间，l++
            while(map.lastKey() - map.firstKey() > limit)
            {
                if(map.get(nums[l]) == 1) map.remove(nums[l]);
                else map.put(nums[l], map.get(nums[l]) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    //滑动窗口，两个单调队列维护区间的最大值和最小值
    public static int longestSubarray2(int[] nums, int limit)
    {
        int n = nums.length;
        int res = 0;
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        int l = 0, r = 0;

        while(r < n)
        {
            while(!max.isEmpty() && nums[r] >= nums[max.peekLast()]) max.pollLast();
            while(!min.isEmpty() && nums[r] <= nums[min.peekLast()]) min.pollLast();
            max.addLast(r);
            min.addLast(r);
            while(Math.abs(nums[max.peekFirst()] - nums[min.peekFirst()]) > limit)
            {
                l++;
                if(max.peekFirst() < l) max.pollFirst();
                if(min.peekFirst() < l) min.pollFirst();

            }

            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
