package com.Leetcode;

/**
 * Leetcode1706,球会落在何处
 * 模拟
 */

import java.util.*;

public class LeetcodeDemo1706 {
    int m, n;
    public int[] findBall(int[][] grid) {
        this.m = grid.length; this.n = grid[0].length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        //模拟小球在不同列掉落的位置
        for(int i = 0; i < n; i++)
        {
            int x = 0, y = i; //当前cur的坐标
            while(x < m - 1)
            {
                int cur = grid[x][y];
                if(check(grid, x, y)) break; //如果在同层会被卡住，直接跳过
                x++; y = cur == 1 ? y + 1 : y - 1;
            }

            if(x == m - 1)
            {
                if(check(grid, x, y)) continue;
                ans[i] = y + grid[x][y];
            }
        }
        return ans;
    }

    public boolean check(int[][] grid, int x, int y)
    {
        int cur = grid[x][y];
        if(cur == 1) //向右
        {
            if(y == n - 1) return true;
            if(grid[x][y + 1] == -1) return true;
        }
        else if(cur == -1)
        {
            if(y == 0) return true;
            if(grid[x][y - 1] == 1) return true;
        }
        return false;
    }

    //ref
    public int[] findBall1(int[][] grid)
    {
        this.m = grid.length; this.n = grid[0].length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) ans[i] = getVal(grid, i);
        return ans;
    }

    public int getVal(int[][] grid, int x)
    {
        int r = 0, c = x;
        while(r < m)
        {
            int ne = c + grid[r][c];
            if(ne < 0 || ne >= n) return -1;
            if(grid[r][c] != grid[r][ne]) return -1;
            r++; c = ne;
        }
        return c;
    }
}
