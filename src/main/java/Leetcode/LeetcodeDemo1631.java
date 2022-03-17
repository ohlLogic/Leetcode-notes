package com.Leetcode;

/**
 * Leetcode1631,最小体力消耗路径
 * 并查集
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetcodeDemo1631 {
    int N = 10009;
    int[] p = new int[N];
    int n, m;
    public void union(int a, int b)
    {
        p[find(a)] = p[find(b)];
    }

    public int find(int x)
    {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public boolean query(int a, int b)
    {
        return p[find(a)] == p[find(b)];
    }
    public int minimumEffortPath(int[][] heights)
    {
        n = heights.length; m = heights[0].length;

        //初始化并查集
        for(int i = 0; i < m * n; i++) p[i] = i;

        //处理边集,向右，向下
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; i++)
            {
                int idx = i * m + j;
                if(i < n - 1)
                {
                    int a = idx, b = (i + 1) * m + j;
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    edges.add(new int[]{a, b, w});
                }

                if(j < m - 1)
                {
                    int a = idx, b = i * m + j + 1;
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    edges.add(new int[]{a, b, w});
                }
            }
        }

        //对边集排序
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        //边集权值从小到大连接，如果，左上角和右下角连通则返回
        for(int[] edge : edges)
        {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if(query(0, n * m - 1)) return w;
        }
        return 0;
    }
}
