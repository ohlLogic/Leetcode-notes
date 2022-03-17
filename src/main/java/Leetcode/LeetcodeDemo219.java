package com.Leetcode;

/**
 * Leetcode219,存在重复元素2
 * 哈希表
 */

import java.util.*;

public class LeetcodeDemo219 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k)
    {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
            if(set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}
