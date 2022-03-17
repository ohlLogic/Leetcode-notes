package com.Leetcode;

/**
 * Leetcode48,旋转图像
 * 转置+翻转每一行元素
 */
public class LeetcodeDemo48 {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3}, {4,5,6},{7,8,9}};
        rotate(mat);

        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }

    public static void rotate(int[][] matrix)
    {
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < m; i++)
        {
            int l = 0, r = n - 1;
            while(l < r)
            {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
    }
}
