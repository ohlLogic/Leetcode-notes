package com.Leetcode;

import java.util.HashMap;

public class LeetcodeDemo1
{
    public static void main(String[] args) {
        int[] nums = {2, 7, 11 ,14};
        for (int i : twoSum(nums, 9)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target)
    {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
