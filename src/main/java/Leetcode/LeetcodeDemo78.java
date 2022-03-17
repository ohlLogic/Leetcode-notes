package com.Leetcode;

/**
 * Leetcode78,子集
 * dfs
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums)
    {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int u)
    {
        res.add(new ArrayList<>(list));
        if(u == nums.length) return;

        for (int i = u; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
