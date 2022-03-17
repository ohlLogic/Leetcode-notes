package com.Leetcode;

import java.util.HashMap;

/**
 * Leetcode217, 存在重复元素
 * 哈希表
 */
public class LeetcodeDemo217 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDulicate(nums));
    }

    public static boolean containsDulicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}
