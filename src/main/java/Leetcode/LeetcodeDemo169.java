package com.Leetcode;

/**
 * Leetcode169,多数元素
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo169 {
    //哈希表
    public int majorityElement(int[] nums)
    {
        int n = nums.length, m = (int) Math.floor(n / 2);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for (Integer integer : map.keySet()) {
            if(map.get(integer) > m) return integer;
        }
        return 0;
    }

    //摩尔投票
    public int majorityElement1(int[] nums)
    {
        int res = nums[0], cnt = 1;
        for(int i = 1; i < nums.length; i++)
        {
            if(res == nums[i]) cnt++;
            else if(--cnt == 0)
            {
                res = nums[i];
                cnt = 1;
            }
        }
        return res;
    }
}
