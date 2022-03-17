package com.Leetcode;

/**
 * Leetcode47,全排序
 * 回溯法+剪枝
 */

import java.util.*;

public class LeetcodeDemo47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        //必须先对数组进行排序，保证相同元素在一起；升序或者降序都可
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] tag = new boolean[n];
        List<Integer> path = new ArrayList<>();
        dfs(res, nums, path, tag);
        return res;
        //
    }

    public static void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, boolean[] tag) {
        if (path.size() == nums.length) res.add(new ArrayList<>(path));

        for (int i = 0; i < nums.length; i++) {
            if (tag[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !tag[i - 1]) continue;
            tag[i] = !tag[i];
            path.add(nums[i]);
            dfs(res, nums, path, tag);
            path.remove(path.size() - 1);
            tag[i] = !tag[i];
        }
    }
}
