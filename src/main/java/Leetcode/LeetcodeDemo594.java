package com.Leetcode;

/**
 * Leetcode594,最长和谐子序列
 *
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo594 {
    //排序+滑动窗口
    public int findLHS(int[] nums)
    {
        int n = nums.length, ans = 0;
        Arrays.sort(nums);
        for(int i = 0, j = 0; j < n; j++)
        {
            while(i < j && nums[j] - nums[i] > 1) i++;
            if(nums[j] - nums[i] == 1) ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    //哈希表
    public int findLHS1(int[] nums)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);

        int ans = 0;
        for(int i : nums)
        {
            if(map.containsKey(i - 1)) ans = Math.max(ans, map.get(i) + map.get(i - 1));
        }
        return ans;
    }
}
