package com.Leetcode;

import java.util.*;

public class LeetcodeDemo752 {
    String t;
    String s = "0000";
    Set<String> set = new HashSet<>();
    public int openLock(String[] deadends, String target)
    {
        this.t = target;
        for(String w : deadends) set.add(w);
        if(set.contains(s)) return -1;
        if(s.equals(t)) return 0;
        int res = bfs();
        return res;
    }

    public int bfs()
    {
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();

        d1.addLast(s);
        m1.put(s, 0);
        d2.addLast(t);
        m2.put(t, 0);

        while(!d1.isEmpty() && !d2.isEmpty())
        {
            int t = -1;
            if(d1.size() <= d2.size()) t = update(d1, m1, m2);
            else t = update(d2, m2, m1);
            if(t != - 1) return t;

        }
        return -1;
    }

    public int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> other)
    {
        String poll = d.pollFirst();
        char[] pcs = poll.toCharArray();
        int n = poll.length();

        for(int i = 0; i < n; i++)
        {
            //锁能够正向转，也可以反向转；枚举偏移量[-1,1]，跳过0
            for(int j = -1; j <= 1; j++)
            {
                if(j == 0) continue;

                //替换字符串
                int origin = pcs[i] - '0';
                int next = (origin + j) % 10;
                if(next == - 1) next = 9;

                char[] clone = pcs.clone();
                clone[i] = (char) (next + '0');
                String sub = String.valueOf(clone);

                //set不存在sub替换字符串
                if(!set.contains(sub))
                {
                    if(cur.containsKey(sub)) continue;
                    if(other.containsKey(sub)) return cur.get(poll) + 1 + other.get(sub);
                    else{
                        d.addLast(sub);
                        cur.put(sub, cur.get(poll) + 1);
                    }
                }
            }
        }
        return -1;
    }
}
