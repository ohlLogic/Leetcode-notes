package com.Leetcode;

/**
 * Leetcode130,被围绕的区域
 *
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo130 {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //BFS
    public void solve(char[][] board)
    {
        int m = board.length, n = board[0].length;

        Deque<int[]> d = new ArrayDeque<>();
        for(int i = 0; i < m; i++)
        {
            if(board[i][0] == 'O')
            {
                d.addLast(new int[]{i, 0});
                board[i][0] = '#';
            }
            if(board[i][n - 1] == 'O')
            {
                d.addLast(new int[]{i, n - 1});
                board[i][n - 1] = '#';
            }
        }

        for(int i = 1; i < n - 1; i++)
        {
            if(board[0][i] == 'O')
            {
                d.addLast(new int[]{0, i});
                board[0][i] = '#';
            }

            if(board[m - 1][i] == 'O')
            {
                d.addLast(new int[]{m - 1, i});
                board[m - 1][i] = '#';
            }
        }

        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            for(int[] dir : dirs)
            {
                int nx = dir[0] + poll[0], ny = dir[1] + poll[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || board[nx][ny] != 'O') continue;
                d.addLast(new int[]{nx, ny});
                board[nx][ny] = '#';
            }
        }


        //构建
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    //DFS
    int m, n;
    public void solve1(char[][] board)
    {
        m = board.length;
        if(m == 0) return;
        n = board[0].length;

        //从边界进行DFS
        for(int i = 0; i < m; i++)
        {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for(int i = 1; i < n - 1; i++)
        {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        //构建
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;

        board[x][y] = '#';
        //四个方向
        dfs(board, x + 1, y);
        dfs(board, x, y + 1);
        dfs(board, x - 1, y);
        dfs(board, x, y - 1);
    }
}
