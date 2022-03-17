package com.Leetcode;

/**
 * Leecode931,下降最下路径和
 * 动态规划
 * dp[i][j]表示以i，j坐标下降的最小和
 * 采用自底向上进行规划
 * dp[i][j] = matrix(i,j) + min(dp(i + 1,j), dp(i+1, j - 1), dp(i+1, j + 1)
 * return min(dp(0,i))  0 <= i < n
 */
public class LeetcodeDemo931 {
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix)
    {
        int n = matrix.length;
        //倒数第二层开始
        for(int i = n - 2; i >= 0; i--)
        {
            for(int j = 0; j < n; j++)
            {
                int best = matrix[i + 1][j];
                if(j > 0) best = Math.min(best, matrix[i + 1][j - 1]);
                if(j < n - 1) best = Math.min(best, matrix[i + 1][j + 1]);
                matrix[i][j] += best;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : matrix[0]) {
            min = Math.min(min, i);
        }
        return min;
    }
}
