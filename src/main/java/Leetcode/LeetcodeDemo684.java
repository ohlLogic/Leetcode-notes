package com.Leetcode;

/**
 * Leetcode684,冗余连接
 *
 */
public class LeetcodeDemo684 {
    int[] p;

    public int find(int x)
    {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public boolean query(int a, int b)
    {
        return p[find(a)] == p[find(b)];
    }

    public void union(int a, int b)
    {
        p[find(b)] = p[find(a)];
    }
    public int[] findRedundantConnection(int[][] edges)
    {
        int n = edges.length;
        p = new int[n + 1];

        //初始化并查集
        for(int i = 1; i <= n; i++) p[i] = i;

        for(int i = 0; i < n; i++)
        {
            int a = edges[i][0], b = edges[i][1];
            if(find(a) != find(b)) union(a, b);
            else return edges[i];
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        LeetcodeDemo684 tt = new LeetcodeDemo684();
        int[][] edges = new int[][]{{1,2},{1,3},{2,3}};
        System.out.println(tt.findRedundantConnection(edges));
    }
}
