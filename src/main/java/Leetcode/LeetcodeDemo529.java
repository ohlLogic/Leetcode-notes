package com.Leetcode;

/**
 * Leetcode529,扫雷游戏
 * BFS
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo529 {
    char[][] board;
    boolean[][] vis;
    int m, n;
    int[] dx = new int[]{-1, -1, 1, 1, 0, 0, 1, -1};
    int[] dy = new int[]{-1, 1, -1, 1, 1, -1, 0, 0};
    public char[][] updateBoard(char[][] board, int[] click)
    {
        //如果是炸弹
        if(board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        this.board = board;
        this.m = board.length; this.n = board[0].length;
        this.vis = new boolean[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(new int[]{click[0], click[1]});
        vis[click[0]][click[1]] = true;


        while(!d.isEmpty())
        {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            int cnt = check(x, y);
            if(cnt > 0) board[x][y] = (char) (cnt + '0');
            else {
                board[x][y] = 'B';
                for(int i = 0; i < 8; i++)
                {
                    int nx = x + dx[i], ny = y + dy[i];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'E' && !vis[nx][ny])
                    {
                        d.addLast(new int[]{nx, ny});
                        vis[nx][ny] = true;
                    }

                }
            }
        }
        return board;
    }

    public int check(int x, int y)
    {
        int cnt = 0;
        for(int i = 0; i < 8; i++)
        {
            int nx = x + dx[i],  ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'M') cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetcodeDemo529 tt = new LeetcodeDemo529();
        char[][] board = new char[][]{{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        tt.updateBoard(board, new int[]{3, 0});
    }
}
