package com.Leetcode;

/**
 * Leetcode779,水位上升的泳池中游泳
 *
 */

import java.util.*;

public class LeetcodeDemo778 {

    //二分+bfs
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int swimInWater(int[][] grid)
    {
        int n = grid.length;
        int l = 0, r = n * n;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(check(grid, mid)) r = mid;
            else l = mid + 1;
        }
        return r;
    }

    public boolean check(int[][] grid, int time)
    {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty())
        {
            int[] pos = queue.pollFirst();
            int x = pos[0], y = pos[1];
            if(x == n - 1 && y == n - 1) return true;

            for(int[] dir : dirs)
            {
                int newX = x + dir[0], newY = y + dir[1];
                int[] to = new int[]{newX, newY};
                if(inArea(n, newX, newY) && !visited[newX][newY] && canMove(grid, pos, to, time))
                {
                    visited[newX][newY] = true;
                    queue.addLast(to);
                }
            }
        }
        return false;
    }

    //判断是否在水池中
    boolean inArea(int n, int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    //判断时间是否达到水位
    boolean canMove(int[][] grid, int[] from, int[] to, int time)
    {
        return time >= Math.max(grid[from[0]][from[1]], grid[to[0]][to[1]]);
    }


    //Kruskal
    int n;
    int[] p;
    void union(int a, int b)
    {
        p[find(a)] = p[find(b)];
    }

    boolean query(int a, int b)
    {
        return find(a) == find(b);
    }

    int find(int x)
    {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int swimWater1(int[][] grid)
    {
        n = grid.length;

        //初始化并查集
        p = new int[n * n];
        for(int i = 0; i < n; i++) p[i] = i;

        //预处理所有的边
        List<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int idx = getIndex(i, j);
                p[idx] = idx;
                if(i + 1 < n)
                {
                    int a = idx, b = getIndex(i + 1, j);
                    int w = Math.max(grid[i][j], grid[i + 1][j]);
                    edges.add(new int[]{a, b, w});
                }

                if(j + 1 < n)
                {
                    int a = idx, b = getIndex(i, j + 1);
                    int w = Math.max(grid[i][j], grid[i][j + 1]);
                    edges.add(new int[]{a, b, w});
                }
            }
        }

        //根据权值w升序
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int start = getIndex(0, 0), end = getIndex(n - 1, n - 1);
        for(int[] edge : edges)
        {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if(query(start, end)) return w;
        }
        return -1;
    }
    int getIndex(int i, int j)
    {
        return i * n + j;
    }
}
