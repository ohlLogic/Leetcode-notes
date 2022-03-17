package com.Leetcode;

/**
 * Leetcode1314,矩形区域和
 * 二维前缀数组
 */
public class LeetcodeDemo1314 {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] temp = matrixBlockSum(mat, 1);
        for(int i = 0; i < temp.length; i++)
            for(int j = 0; j < temp[0].length; j++)
                System.out.println(temp[i][j]);
    }

    public static int[][] matrixBlockSum(int[][] mat, int k)
    {
        int m = mat.length;
        int n = mat[0].length;

        //处理二维数组前缀和
        int[][] temp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j ++)
            {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1] - temp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int[][] answer = new int[m][n];

        int r_min, r_max, c_min, c_max;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                r_max = Math.min(i + k + 1, m);
                c_max = Math.min(j + k + 1, n);
                r_min = Math.max(i - k + 1, 1);
                c_min = Math.max(j - k + 1, 1);
                answer[i][j] = temp[r_max][c_max] - temp[r_min - 1][c_max] - temp[r_max][c_min - 1] + temp[r_min - 1][c_min - 1];
            }
        }
        return answer;
    }

}
