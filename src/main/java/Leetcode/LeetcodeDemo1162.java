package com.Leetcode;

/**
 * Leetcode1162,地图分析
 * BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo1162 {
    //单源BFS
    int n;
    int[][] grid;

    public int maxDistance(int[][] grid) {
        this.n = grid.length;
        this.grid = grid;
        int res = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) res = Math.max(res, bfs(i, j));
            }
        }
        return res;
    }

    public int bfs(int x, int y) {
        //模拟四个方向
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        d.addLast(new int[]{x, y});

        //坐标(x,y)因此key = x * n + y也是唯一
        map.put(x * n + y, 0);

        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            if(grid[dx][dy] == 1) return step;

            for(int[] dir : dirs)
            {
                int nx = dx + dir[0], ny = dy + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                int key = nx * n + ny;
                if(map.containsKey(key)) continue;
                d.addLast(new int[]{nx, ny});
                map.put(key, step + 1);
            }
        }
        return -1;
    }

    //多源BFS
    public int maxDistance1(int[][] grid)
    {
        int n = grid.length;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        //将所有的真实源点入队，相当于超级源点弹出队列加入了真实源点
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1)
                {
                    d.addLast(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }

        int res = -1;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx  * n + dy);
            for(int[] dir : dirs)
            {
                int nx = dx + dir[0], ny = dy + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                //说明已经被访问过，直接跳过
                if(grid[nx][ny] != 0) continue;
                grid[nx][ny] = step + 1;
                d.add(new int[]{nx, ny});
                map.put(nx * n + ny, step + 1);
                res = Math.max(res, step + 1);
            }
        }
        return res;
    }
}
