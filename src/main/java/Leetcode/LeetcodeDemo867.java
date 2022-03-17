package com.Leetcode;

/**
 * Leetcode867，转置矩阵
 * 模拟
 *
 */
public class LeetcodeDemo867 {
    public static void main(String[] args) {

    }

    public static int[][] transpose(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        int[][] tt = new int[n][m];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                tt[j][i] = matrix[i][j];
            }
        }
        return tt;
    }
}
