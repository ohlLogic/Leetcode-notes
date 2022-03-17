package com.Leetcode;

/**
 * Leetcode851,喧闹与富有
 * 拓扑排序
 */

import java.util.*;

public class LeetcodeDemo851 {
    public int[] loudAndRich(int[][] richer, int[] quiet)
    {
        int n = quiet.length;
        int[] ans = new int[n], in = new int[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] r : richer)
        {
            int a = r[0], b = r[1];
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(b);
            map.put(a, list);
            in[b]++;
        }

        Deque<Integer> d = new ArrayDeque<>();

        //将入度为0的结点加入队列
        for(int i = 0; i < n; i++)
        {
            ans[i] = i;
            if(in[i] == 0) d.addLast(i);
        }

        while(!d.isEmpty())
        {
            int t = d.pollFirst();
            for(int u : map.getOrDefault(t, new ArrayList<>()))
            {
                if(quiet[ans[t]] < quiet[ans[u]]) ans[u] = ans[t];
                if(--in[u] == 0) d.addLast(u);
            }
        }
        return ans;
    }
}
