package com.Leetcode;

/**
 * Leetcode403,青蛙过河
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo403 {
    //dfs(TLE)
    Map<Integer, Integer> map = new HashMap<>();
    public boolean canCross(int[] stones)
    {
        int n = stones.length;
        //将石子的高度和下标存入哈希表，方便查询
        for(int i = 0; i < n; i++) map.put(stones[i], i);

        //第一步是固定经过步长1到达第一块石子
        if(!map.containsKey(1)) return false;
        return dfs(stones, n, 1, 1);
    }

    /**
     * 判定是否能够跳到最后一块石子
     * @param ss 石子列表（不变）
     * @param n 石子长度（不变）
     * @param u 当前石子的下标
     * @param k 上一次跳跃步数
     * @return 是否能够跳过最后一块石子
     */
    public boolean dfs(int[] ss, int n, int u, int k)
    {
        //如果到达最后一块石子的标号就返回true
        if(u == n - 1) return true;

        for(int i = -1; i <= 1; i++)
        {
            //k + i代表下一步的跳跃高度，原地踏步直接跳过
            if(k + i == 0) continue;
            int next = ss[u] + k + i;
            //如果存在下一步的石子，跳跃到下一步 dfs
            if(map.containsKey(next))
            {
                boolean cur = dfs(ss, n, map.get(next), k + i);
                if(cur) return true;
            }
        }
        return false;
    }

    Map<String, Boolean> cache = new HashMap<>();
    //记忆化搜索
    public boolean canCross1(int[] stones)
    {

        int n = stones.length;
        for(int i = 0; i < n; i++) map.put(stones[i], i);
        if(!map.containsKey(1)) return false;
        return dfs1(stones, stones.length, 1, 1);
    }
    boolean dfs1(int[] ss, int n, int u, int k)
    {
        String key = u + "_" + k;
        if(cache.containsKey(key)) return cache.get(key);
        if(u == n - 1) return true;
        for(int i = -1; i <= 1; i++)
        {
            if(k + i == 0) continue;
            int next = ss[u] + k + i;
            if(map.containsKey(next))
            {
                boolean cur = dfs(ss, n, map.get(next), k + i);
                cache.put(key, cur);
                if(cur) return true;
            }
        }
        cache.put(key, false);
        return false;
    }

    //bfs
    public boolean canCross2(int[] ss) {
        int n = ss.length;
        for (int i = 0; i < n; i++) {
            map.put(ss[i], i);
        }
        // check first step
        if (!map.containsKey(1)) return false;

        boolean[][] vis = new boolean[n][n];
        Deque<int[]> d = new ArrayDeque<>();
        vis[1][1] = true;
        d.addLast(new int[]{1, 1});

        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int idx = poll[0], k = poll[1];
            if (idx == n - 1) return true;
            for (int i = -1; i <= 1; i++) {
                if (k + i == 0) continue;
                int next = ss[idx] + k + i;
                if (map.containsKey(next)) {
                    int nIdx = map.get(next), nK = k + i;
                    if (nIdx == n - 1) return true;
                    if (!vis[nIdx][nK]) {
                        vis[nIdx][nK] = true;
                        d.addLast(new int[]{nIdx, nK});
                    }
                }
            }
        }

        return false;
    }

}
