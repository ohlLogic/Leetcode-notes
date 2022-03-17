package com.Leetcode;

/**
 * Leetcode417,太平洋大西洋水流问题
 */

import java.util.*;
public class LeetcodeDemo417 {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    //BFS
    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        int m = heights.length;
        if(m == 0) return null;
        int n = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[][] reachA = new boolean[m][n];
        boolean[][] reachB = new boolean[m][n];

        Deque<int[]> d = new ArrayDeque<>();


        //首先地图边界进行标记
        for(int i = 0; i < m; i++)
        {
            reachA[i][0] = true;
            reachB[i][n - 1] = true;
        }

        for(int i = 0; i < n; i++)
        {
            reachA[0][i] = true;
            reachB[m - 1][i] = true;
        }

        //先对A进行bfs
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(reachA[i][j]) d.addLast(new int[]{i, j});
            }
        }

        while(!d.isEmpty())
        {
            int[] cur = d.pollFirst();
            int num = heights[cur[0]][cur[1]];
            for(int[] dir : dirs)
            {
                int nx = dir[0] + cur[0], ny = dir[1] + cur[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || num > heights[nx][ny] || reachA[nx][ny]) continue;
                d.addLast(new int[]{nx, ny});
                reachA[nx][ny] = true;
            }
        }

        //对B进行bfs
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(reachB[i][j]) d.addLast(new int[]{i, j});
            }
        }

        while(!d.isEmpty())
        {
            int[] cur = d.pollFirst();
            int num = heights[cur[0]][cur[1]];
            for(int[] dir : dirs)
            {
                int nx = dir[0] + cur[0], ny = dir[1] + cur[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || num > heights[nx][ny] || reachB[nx][ny]) continue;
                d.addLast(new int[]{nx, ny});
                reachB[nx][ny] = true;
            }
        }

        //构建
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(reachA[i][j] && reachB[i][j])
                {
                    temp.add(i); temp.add(j);
                    res.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        return res;
    }

    //dfs
    int m, n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic1(int[][] heights)
    {
         m = heights.length;
         if(m == 0) return null;
         n = heights[0].length;
         if(n == 0) return null;
         this.heights = heights;

         List<List<Integer>> res = new ArrayList<>();
         List<Integer> temp = new ArrayList<>();
         boolean[][] reachA = new boolean[m][n];
         boolean[][] reachB = new boolean[m][n];

         for(int i = 0; i < n; i++)
         {
             dfs(0, i, reachA);
             dfs(m - 1, i, reachB);
         }

         for(int i = 0; i < m; i++)
         {
             dfs(i, 0, reachA);
             dfs(i, n - 1, reachB);
         }

         //构建res
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(reachA[i][j] && reachB[i][j])
                {
                    temp.add(i); temp.add(j);
                    res.add(new ArrayList<>(temp));
                    temp.clear();
                }
            }
        }
        return res;
    }


    public void dfs(int x, int y, boolean[][] reach)
    {
        reach[x][y] = true;
        for(int[] dir : dirs)
        {
            int nx = x + dir[0], ny = y + dir[1];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || reach[nx][ny] || heights[x][y] > heights[nx][ny]) continue;
            dfs(nx, ny, reach);
        }
    }
    public static void main(String[] args) {
        int[][] height = new int[][]{{1,2,2,3,5}, {3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        LeetcodeDemo417 tt = new LeetcodeDemo417();
        System.out.println(tt.pacificAtlantic(height));
    }
}
