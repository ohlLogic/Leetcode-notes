package com.Leetcode;

/**
 * Leetcode841,钥匙和房间
 * DFS，BFS
 */

import java.util.*;
public class LeetcodeDemo841 {
    public static void main(String[] args) {
        LeetcodeDemo841 tt = new LeetcodeDemo841();
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(){{add(1);}});
        res.add(new ArrayList<>(){{add(2);}});
        res.add(new ArrayList<>(){{add(3);}});
        res.add(new ArrayList<>());
        System.out.println(res);

        System.out.println(tt.canVisitAllRooms(res));
    }

    //BFS(自写）
    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        Set<Integer> set = new HashSet<>();
        Deque<Integer> d = new ArrayDeque<>();
        boolean[] vis = new boolean[n + 1];
        vis[0] = true;


        //将0号房间钥匙加入set集合中
        set.addAll(rooms.get(0));

        for (Integer integer : rooms.get(0)) {
            d.addLast(integer);
        }

        while(!d.isEmpty())
        {
            int num = d.pollFirst();
            if(vis[num]) continue;
            vis[num] = true;
            set.addAll(rooms.get(num));

            for (Integer integer : rooms.get(num)) {
                d.addLast(integer);
            }
        }

        //检查1-n房间是否在set集合中
        for(int i = 1; i < n; i++)
        {
            if(!set.contains(i)) return false;
        }
        return true;
    }

    //BFS，简洁
    public boolean canVisitAllRooms1(List<List<Integer>> rooms)
    {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Deque<Integer> d = new ArrayDeque<>();
        vis[0] = true;

        d.add(0);
        while(!d.isEmpty())
        {
            int x = d.pollFirst();
            num++;
            for(int it : rooms.get(x))
            {
                if(!vis[it])
                {
                    vis[it] = true;
                    d.add(it);
                }
            }
        }
        return num == n;
    }

    //DFS
    boolean[] vis;
    int num;
    public boolean canVisitAllRooms2(List<List<Integer>> rooms)
    {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    public void dfs(List<List<Integer>> rooms, int x)
    {
        vis[x] = true;
        num++;
        for(int it : rooms.get(x))
        {
            if(!vis[it]) dfs(rooms, it);
        }
    }
}
