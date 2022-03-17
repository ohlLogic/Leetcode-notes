package com.Leetcode;

/**
 * Leetcode1583,统计不开心的朋友
 * 模拟
 */
public class LeetcodeDemo1583 {
    public static void main(String[] args) {

    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        boolean[][] unhappyOhly = new boolean[n][n];
        for (int[] pair : pairs) {
            preProcess(unhappyOhly, preferences, pair[0], pair[1]);
            preProcess(unhappyOhly, preferences, pair[1], pair[0]);
        }

        int res = 0;
        for (int i = 0; i < unhappyOhly.length; i++) {
            for (int j = 0; j < unhappyOhly[0].length; j++) {
                if (unhappyOhly[i][j] && unhappyOhly[j][i]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
    public void preProcess(boolean[][] unhappyOnly, int[][] preferences, int x, int y)
    {
        for(int u : preferences[x])
        {
            if(u != y) unhappyOnly[x][u] = true;
            else break;
        }
    }
}
