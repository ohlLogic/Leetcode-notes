package com.Leetcode;

public class LeetcodeDemo685 {
    int[] p;

    public int find(int x)
    {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public void union(int a, int b)
    {
        p[find(a)] = p[find(b)];
    }
    public int[] findRedundantDirectedConnection(int[][] edges)
    {
        int n = edges.length;

        p = new int[n + 1];

        //并查集初始化
        for(int i = 1; i <= n; i++) p[i] = i;

        for(int i = 0; i < n; i++)
        {
            int a = edges[i][0], b = edges[i][1];
            if(find(a) != find(b)) union(a, b);
            else return edges[i];
        }
        return new int[0];
    }
}
