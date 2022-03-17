package com.Leetcode;

/**
 * Leetcode73, 矩阵置零
 */
public class LeetcodeDemo73 {
    public static void main(String[] args) {

    }

    public static void setZeros(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }

    //使用matrix的第一行和第一列代替标志数组，用rowtag，coltag记录第一行和第一列原来是否含有0
    public static void setZeros1(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        boolean rowtag = false, coltag = false;

        //记录标志位
        for(int i = 0; i < m; i++)
        {
            if(matrix[i][0] == 0)
            {
                coltag = true;
                break;
            }
        }
        for(int j = 0; j < n; j++)
        {
            if(matrix[0][j] == 0)
            {
                rowtag = true;
                break;
            }
        }

        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][j] == 0) matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if(rowtag)
        {
            for(int j = 0; j < n; j++) matrix[0][j] = 0;
        }
        if(coltag)
        {
            for(int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }
}