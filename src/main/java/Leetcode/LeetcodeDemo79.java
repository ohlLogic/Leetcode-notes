package com.Leetcode;

/**
 * Leetcode79,单词搜索
 * dfs，回溯
 */
public class LeetcodeDemo79 {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    boolean[][] visited;
    int m, n;
    String word;
    public boolean exist(char[][] board, String word) {
        m = board.length; n = board[0].length;
        visited = new boolean[m][n];
        this.word = word;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(dfs(board, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, int len)
    {
        //判断当目前遍历到word最后一个字符时是否相等
        if(len == word.length() - 1) return board[x][y] == word.charAt(len);

        //当前字符相等，再向下dfs
        if(board[x][y] == word.charAt(len))
        {
            visited[x][y] = true;
            for(int[] dir : dirs)
            {
                int newX = x + dir[0], newY = y + dir[1];
                if(inArea(newX, newY) && !visited[newX][newY])
                {
                    if(dfs(board, newX, newY, len + 1)) return true;
                }
            }
            //回溯
            visited[x][y] = false;
        }
        return false;
    }

    public boolean inArea(int x, int y)
    {
        return x >=0 && x < m && y >= 0 && y < n;
    }
}
