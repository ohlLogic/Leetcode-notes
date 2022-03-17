package com.Leetcode;

/**
 * Leetcode560,和为k的子数组
 * 前缀和
 */

import java.util.HashMap;

public class LeetcodeDemo560 {
    public int subarraySum(int[] nums, int k)
    {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, pre = 0;
        map.put(0, 1);
        for(int i = 0; i < n; i++)
        {
            pre += nums[i];
            if(map.containsKey(pre - k)) count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
