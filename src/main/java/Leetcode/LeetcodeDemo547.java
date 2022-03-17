package com.Leetcode;

/**
 * Leetcode547,省份数量
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo547 {
    int[] p;
    int n;

    public void init()
    {
        for(int i = 0; i < n; i++) p[i] = i;
    }


    public int find(int x)
    {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public boolean query(int a, int b)
    {
        return find(a) == find(b);
    }

    public void union(int a, int b)
    {
        p[find(a)] = p[find(b)];
    }

    //并查集
    public int findCircleNum(int[][] isConnected)
    {
        n = isConnected.length;
        p = new int[n];

        //1.初始化并查集p
        init();

        //2.建立并查集
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(isConnected[i][j] == 1) union(j, i);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            if(p[i] == i) cnt++;
        }
        return cnt;
    }

    //DFS
    public  int findCircleNum1(int[][] isConnected)
    {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++)
        {
            if(!vis[i])
            {
                cnt++;
                dfs(i, isConnected, vis);
            }
        }
        return cnt;
    }


    public void dfs(int i, int[][] isConnected, boolean[] vis)
    {
        //标记
        vis[i] = true;

        for(int j = 0; j < isConnected.length; j++)
        {
            if(isConnected[i][j] == 1 && !vis[j]) dfs(j, isConnected, vis);
        }
    }


    //BFS
    public int findCircleNum2(int[][] isConnected)
    {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        int cnt = 1;
        Deque<Integer> d = new ArrayDeque<>();
        for(int i = 0; i < n; i++)
        {
            if(!vis[i])
            {
                cnt++;
                d.addLast(i);
                vis[i] = true;
                while(!d.isEmpty())
                {
                    int v = d.pollFirst();
                    for(int w = 0; w < n; w++)
                    {
                        if(isConnected[v][w] == 1 && !vis[w])
                        {
                            vis[w] = true;
                            d.addLast(w);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
