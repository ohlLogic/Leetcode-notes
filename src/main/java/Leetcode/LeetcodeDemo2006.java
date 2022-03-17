package com.Leetcode;

/**
 * Leetcode2006,差的绝对值为K的数对数目
 * 哈希表
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo2006 {
    public int countKDifference(int[] nums, int k)
    {
        /**
         * 思路：将nums数组每个元素依次存入哈希表map，当遍历到后面元素时
         * 如果当前与map存储的元素相同，则ans += map.get(xx)
         */
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
        {
            if(map.containsKey(num + k)) ans += map.get(num + k);
            if(map.containsKey(num - k)) ans += map.get(num - k);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}
