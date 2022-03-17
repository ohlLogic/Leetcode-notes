package com.Leetcode;

/**
 * Leetcode136,只出现一次的数字
 * 位运算
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo136 {
    public static void main(String[] args) {
        LeetcodeDemo136 tt = new LeetcodeDemo136();
        int[] nums = {4,1,2,1,2};
        System.out.println(tt.singleNumber(nums));
    }
    public int singleNumber(int[] nums)
    {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(nums[i])) map.remove(nums[i]);
            else map.put(nums[i], 1);
        }
        for (Integer integer : map.keySet()) {
            return integer;
        }
        return 0;
    }

    //位运算
    public int singleNumber1(int[] nums)
    {
        int tt = 0;
        for(int i : nums) tt ^= i;
        return tt;
    }
}
