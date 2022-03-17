package com.Leetcode;

/**
 * Leetcode397,整数替换
 * DFS，BFS，位运算
 */

import java.util.*;
public class LeetcodeDemo397 {
    //DFS
    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement(int n)
    {
        return dfs(n * 1L);
    }

    public int dfs(long n)
    {
        if(n == 1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n - 1), dfs(n + 1));
        map.put(n, ++ans);
        return ans;
    }

    //BFS
    public int integerReplacement1(int n)
    {
        if(n == 1) return 0;
        Map<Long, Integer> m = new HashMap<>();
        Deque<Long> d = new ArrayDeque<>();
        d.addLast(n * 1L);
        m.put(n * 1L, 0);
        while(!d.isEmpty())
        {
            long t = d.pollFirst();
            int step = m.get(t);
            long[] ns = t % 2 == 0 ? new long[]{t / 2} : new long[]{t + 1, t - 1};
            for(long x : ns)
            {
                if(x == 1) return step + 1 ;
                if(!m.containsKey(x))
                {
                    map.put(x, step + 1);
                    d.addLast(x);
                }
            }
        }
        return -1;
    }

    //位运算
    public int integerReplacement2(int _n)
    {
        long n = _n;
        int ans = 0;
        while(n > 1)
        {
            if(n % 2 == 0) n >>= 1;
            else{
                if(n != 3 && ((n >> 1) & 1) == 1) n++;
                else n--;
            }
            ans++;
        }
        return ans;
    }
}
