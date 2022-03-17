package com.Leetcode;

/**
 * Leetcode46,全排列
 * DFS,回溯法
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo46 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums)
    {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0) return res;
        List<Integer> path = new ArrayList<>();
        dfs(res, nums, path);
        return res;
    }

    public static void dfs(List<List<Integer>> res, int[] nums, List<Integer> path) {
        if(path.size() == nums.length) res.add(new ArrayList<>(path));

        for(int i = 0; i < nums.length; i++)
        {
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            dfs(res, nums, path);
            path.remove(path.size() - 1);
        }
    }

}
