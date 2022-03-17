package com.Leetcode;

/**
 * Leetcode304,二维区域和检索
 * 二维前缀数组
 */
public class LeetcodeDemo304 {
    public static void main(String[] args) {

    }

    int[][] temp;

    public LeetcodeDemo304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        temp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1] - temp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return temp[row2 + 1][col2 + 1] - temp[row1][col2 + 1] - temp[row2 + 1][col1] + temp[row1][col1];
    }
}
