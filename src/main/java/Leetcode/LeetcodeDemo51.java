package com.Leetcode;

/**
 * Leetcode51,N皇后
 * DFS
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo51 {
    List<List<String>> res = new ArrayList<>();
    List<String> tt = new ArrayList<>();
    int n;
    boolean[] col, dg, udg;
    char[][] chess;
    public List<List<String>> solveNQueens(int n)
    {
        this.n = n;
        //列
        col = new boolean[20];
        //正对角线，需要加上偏移量n
        dg = new boolean[20];
        //反对角线
        udg = new boolean[20];
        //棋盘
        chess = new char[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                chess[i][j] = '.';
            }
        }
        dfs(0);
        return res;
    }

    //按层遍历
    public void dfs(int u)
    {
        if(u == n)
        {
            //保存
            for(char[] cur : chess)
            {
                tt.add(String.valueOf(cur));
            }
            res.add(new ArrayList<>(tt));
            tt.clear();
            return;
        }

        for(int i = 0; i < n; i++)
        {
            //剪枝
            if(!col[i] && !dg[n - u + i] && !udg[u + i])
            {
                chess[u][i] = 'Q';
                col[i] = dg[n - u + i] = udg[u + i] = true;
                dfs(u + 1);
                //回溯
                col[i] = dg[n - u + i] = udg[u + i] = false;
                chess[u][i] = '.';
            }
        }
    }
}
