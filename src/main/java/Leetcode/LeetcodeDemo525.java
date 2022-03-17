package com.Leetcode;

/**
 * Leetcode525,连续数组
 * 前缀和 + 哈希表
 */

import java.util.HashMap;
import java.util.Map;


public class LeetcodeDemo525 {
    //前缀和 + 哈希表
    public int findMaxLength(int[] nums)
    {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, -1);

        for(int i = 0; i < n; i++)
        {
            if(nums[i] == 0) sum--;
            else sum++;

            if(map.containsKey(sum)) ans = Math.max(ans, i - map.get(sum));
            else map.put(sum, i);
        }
        return ans;
    }
}
