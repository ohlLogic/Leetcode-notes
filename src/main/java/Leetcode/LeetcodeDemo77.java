package com.Leetcode;

/**
 * Leetcode77,组合
 * dfs
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> combine(int n, int k)
    {
        vis = new boolean[n + 1];
        dfs(n, 1, k);
        return res;
    }

    public void dfs(int n, int u, int k)
    {
        //剪枝，如果当前cur长度加上剩下区间长度小于k，直接return
        if(cur.size() + (n - u + 1) < k) return;
        if(cur.size() == k)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        //选择当前位置
        cur.add(u);
        dfs(n, u + 1, k);
        cur.remove(cur.size() - 1);
        dfs(n, u + 1, k);
    }
}
