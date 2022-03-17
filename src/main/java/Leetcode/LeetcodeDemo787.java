package com.Leetcode;

/**
 * Leetcode787,K站中转内最便宜的航班
 * 图论
 */

import java.util.Arrays;

public class LeetcodeDemo787 {
    int N = 110, INF = 0x3f3f3f3f;
    int[] dist = new int[N];
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
    {
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for(int limit = 0; limit < k + 1; limit++)
        {
            int[] clone = dist.clone();
            for(int[] f : flights)
            {
                int x = f[0], y = f[1], w = f[2];
                dist[y] = Math.min(dist[y], clone[x] + w);
            }
        }
        return dist[dst] > INF / 2 ? -1 : dist[dst];
    }
}
