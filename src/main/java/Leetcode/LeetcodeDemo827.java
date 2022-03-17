package com.Leetcode;

/**
 * Leetcode827,最大人工岛
 * 双DFS
 */

import java.util.*;

public class LeetcodeDemo827 {
    int m, n;
    int[][] grid;
    boolean[][] vis;

    //TLE
    public int largestIsland(int[][] grid)
    {
        this.m = grid.length; this.n = grid[0].length;
        this.grid = grid;
        vis = new boolean[m][n];

        int max = -1;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < m; k++) Arrays.fill(vis[k], false);
                if(grid[i][j] == 0)
                {
                    grid[i][j] = 1;
                    max = Math.max(max, dfs(i, j));
                    grid[i][j] = 0;
                }
            }
        }
        return max == - 1 ? m * n : max;
    }

    public int dfs(int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || vis[x][y]) return 0;

        vis[x][y] = true;

        return dfs(x + 1, y) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x, y - 1) + 1;
    }


    public int largestIsland1(int[][] grid)
    {
        this.m = grid.length; n = grid[0].length;
        //1.首先DFS出每个陆地的大小，保存在map中，idx为同一个快区域的编号
        Map<Integer, Integer> map = new HashMap<>();

        int idx = 2;
        int maxArea = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = dfs(i, j, idx);
                    maxArea = Math.max(maxArea, area);
                    map.put(idx, area);
                    idx++;
                }
            }
        }

        //2.遍历海洋，找到相邻陆地面积最大的航洋格子
        int res = 0;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 0)
                {
                    int plusArea = dfs(i, j, map);
                    res = Math.max(res, plusArea);
                }
            }
        }
        //可能没有海洋，全是陆地
        return maxArea > res ? maxArea : res;
    }


    public int dfs(int x, int y, int idx)
    {
        if(!inArea(x, y) || grid[x][y] != 1) return 0;

        //标记
        grid[x][y] = idx;
        return dfs(x + 1, y, idx) + dfs(x, y + 1, idx) + dfs(x - 1, y, idx) + dfs(x, y - 1, idx) + 1;
    }

    public int dfs(int x, int y, Map<Integer, Integer> map)
    {
        if(!inArea(x, y) || grid[x][y] != 0) return 0;

        //叠加面积
        int cnt = 0;

        //去重，可能连接的是同一块陆地
        Set<Integer> set = new HashSet<>();
        //如果在范围内，并且被标记过
        if(inArea(x - 1, y) && grid[x - 1][y] >= 2) set.add(grid[x - 1][y]);

        if(inArea(x + 1, y) && grid[x + 1][y] >= 2) set.add(grid[x + 1][y]);

        if(inArea(x, y + 1) && grid[x][y + 1] >= 2) set.add(grid[x][y + 1]);

        if(inArea(x, y - 1) && grid[x][y - 1] >= 2) set.add(grid[x][y - 1]);

        for(Integer num : set) cnt += map.get(num);

        return ++cnt;

    }

    public boolean inArea(int x, int y)
    {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        LeetcodeDemo827 tt = new LeetcodeDemo827();
        int[][] grid = {{1, 1}, {1, 0}};
        System.out.println(tt.largestIsland1(grid));
    }
}
