package com.Leetcode;

/**
 * Leetcode40,组合总和2
 * dfs
 */

import java.util.*;

public class LeetcodeDemo40 {
    Set<List<Integer>> res = new HashSet<>();
    List<Integer> list = new ArrayList<>();
    int n;

    //某些数据会TLE
    public List<List<Integer>> combinationSum2(int[] candicates, int target) {
        Arrays.sort(candicates);
        n = candicates.length;
        dfs(candicates, target, 0);
        return new ArrayList<>(res);
    }

    public void dfs(int[] tt, int t, int u) {
        if (0 == t) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (u == n || t < 0) return;

        //选择第u个数
        list.add(tt[u]);
        dfs(tt, t - tt[u], u + 1) ;
        //回溯
        list.remove(list.size() - 1);
        //不选择第u 个数
        dfs(tt, t, u + 1);
    }

    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> d = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int[] candicates, int target)
    {
        Arrays.sort(candicates);
        boolean[] flag = new boolean[candicates.length];
        dfs1(candicates, target, 0, flag);
        return lists;
    }

    public void dfs1(int[] tt, int t, int u, boolean[] flag)
    {
        if(sum == t)
        {
            lists.add(new ArrayList<>(d));
            return;
        }

        for(int i = u; i < tt.length && tt[i] + sum <= t; i++)
        {
            //同层的第一个节点已经被访问过，直接跳过
            if(i > 0 && tt[i] == tt[i - 1] && !flag[i - 1]) continue;

            flag[i] = true;
            sum += tt[i];
            d.push(tt[i]);
            dfs1(tt, t, i + 1, flag);
            sum -= tt[i];
            flag[i] = false;
            d.poll();
        }
    }
}
