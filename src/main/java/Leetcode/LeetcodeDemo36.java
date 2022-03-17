package com.Leetcode;

/**
 * Leetcode36,有效的数独
 */
public class LeetcodeDemo36 {
    public static void main(String[] args) {

    }

    //boxIndex神奇
    public static boolean isVaildSudoku(char[][] board)
    {
        //记录每行数字1-9是否被标记
        boolean[][] row = new boolean[9][9];
        //记录每列数字1-9是否被标记
        boolean[][] col = new boolean[9][9];
        //记录每个小方块内数字1-9是否被标记
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.')
                {
                    int num = board[i][j] - '1', boxIndex = (i / 3) * 3 + j / 3;
                    if(row[i][num] || col[j][num] || box[boxIndex][num]) return false;
                    else{
                        row[i][num] = true;
                        col[j][num] = true;
                        box[boxIndex][num] = true;
                    }
                }
            }

        }
        return true;
    }
}
