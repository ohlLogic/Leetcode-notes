package com.Leetcode;

/**
 * Leetcode794,有效的井字游戏
 * 模拟
 */
public class LeetcodeDemo794 {
    public boolean validTicTacToe(String[] board)
    {
        char[][] cs = new char[3][3];

        int cntx = 0, cnto = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                char c = board[i].charAt(j);
                if(c == 'X') cntx++;
                if(c == 'O') cnto++;
                cs[i][j] = c;
            }
        }
        //检查棋盘是否已经达到获胜条件
        boolean tagx = check(cs, 'X'), tago = check(cs, 'O');
        if(cntx - cnto < 0 || cntx - cnto > 1) return false;
        if(tagx && cntx <= cnto) return false;
        if(tago && cntx != cnto) return false;
        if(tago && tagx) return false;
        return true;

    }

    public boolean check(char[][] cs, char c)
    {
        for(int i = 0; i < 3; i++)
        {
            if(cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
            if(cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
        }

        //斜边
        boolean a = true, b = true;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(i == j) a &= cs[i][j] == c;
                if(i + j == 2) b &= cs[i][j] == c;
            }
        }
        return a || b;
    }
}
