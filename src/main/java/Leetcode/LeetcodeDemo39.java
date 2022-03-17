package com.Leetcode;

/**
 * Leetcode39,组合总和
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo39 {
    public static void main(String[] args) {
        LeetcodeDemo39 tt = new LeetcodeDemo39();
        int[] nums = {2,3,6,7};
        System.out.println(tt.combinationSum(nums, 7));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int n, t;
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        n = candidates.length; t = target;
        dfs(candidates, 0, 0);
        return res;
    }

    public void dfs(int[] tt, int u, int sum)
    {
        if(sum == t)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        if(u == n || sum > t) return;

        for(int i = 0; tt[u] * i <= t; i++)
        {
            sum += tt[u] * i;
            for(int j = i; j > 0; j --) list.add(tt[u]);
            dfs(tt, u + 1, sum);
            sum -= tt[u] * i;
            for(int j = i; j > 0; j --) list.remove(list.size() - 1);
        }

    }
}
