package com.Leetcode;

/**
 * Leetcode419,甲板上的战舰
 * DFS
 */
public class LeetcodeDemo419 {
    int m, n;
    char[][] board;
    int idx = 0;
    public int countBattleships(char[][] board)
    {
        m = board.length; n = board[0].length;
        this.board = board;

        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == 'X') {
                    idx++;
                    dfs(i, j);
                }
            }
        }
        return idx;
    }

    public void dfs(int x, int y)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'X') return;
        board[x][y] = '.';

        dfs(x + 1, y);
        dfs(x - 1, y);
        dfs(x, y + 1);
        dfs(x, y - 1);
    }
}
