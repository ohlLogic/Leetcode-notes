package com.Leetcode;

/**
 * Leetcode766，托普利茨矩阵
 * 模拟
 */
public class LeetcodeDemo766 {
    public static void main(String[] args) {

    }

    //判断左上角是否相等
    public static boolean isToeplitzMatrix(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }


    //按线进行遍历
    public static boolean isToeplitzMatrix1(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        int row = m, col = n;
        while(col-- > 0)
        {
            for(int i = 0, j = col, val = matrix[i++][j++]; i < m && j < n; i++, j++)
                if(matrix[i][j] != val) return false;
        }

        while(row-- > 0)
        {
            for(int i = row, j = 0, val = matrix[i++][j++]; i < m && j < n; i++, j++)
                if(matrix[i][j] != val) return false;
        }
        return true;
    }
}
