package com.Leetcode;

/**
 * Leetcode63,不同路径2
 */
public class LeetcodeDemo63 {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(mat));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid)
    {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m + 1][n + 1];

        //初始状态
        dp[1][1] = 1;

        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(i != 1 || j != 1)
                {
                    if(obstacleGrid[i - 1][j - 1] == 1) dp[i][j] = 0;
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
