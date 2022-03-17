package com.Leetcode;

/**
 * Leetcode815,公交路线
 * BFS
 */

import java.util.*;

public class LeetcodeDemo815 {
    int[][] routes;
    int s, t;

    public int numBusesToDestination(int[][] routes, int source, int target)
    {
        this.routes = routes;
        this.s = source; this.t = target;
        if(s == t) return 0;
        return bfs();
    }

    public int bfs()
    {
        //记录某个车站可以路过的汽车编号i
        Map<Integer, Set<Integer>> map = new HashMap<>();

        //队列记录乘坐的汽车编号i
        Deque<Integer> d = new ArrayDeque<>();

        //记录进入该路线的距离，如果上车就直接记录加1
        Map<Integer, Integer> m = new HashMap<>();
        int n = routes.length;
        for(int i = 0; i < n; i++)
        {
            for(int station : routes[i])
            {
                //将起点可以进入的路线加入队列
                if(station == s)
                {
                    d.addLast(i);
                    m.put(i, 1);
                }
                Set<Integer> set = map.getOrDefault(station, new HashSet<>());
                set.add(i);
                map.put(station, set);
            }
        }

        while(!d.isEmpty())
        {
            int poll = d.pollFirst();
            int step = m.get(poll);

            //遍历该汽车路线所包含的车站
            for(int station : routes[poll])
            {
                if(station == t) return step;

                //将该路线的车站发起的路线，加入队列
                Set<Integer> lines = map.get(station);
                if(lines == null) continue;
                for(int nr : lines)
                {
                    if(!m.containsKey(nr))
                    {
                        m.put(nr, step + 1);
                        d.add(nr);
                    }
                }
            }
        }
        return -1;
    }
}
