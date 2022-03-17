package com.Leetcode;

/**
 * Leetcode689,三个无重叠子数组的最大和
 * 动态规划
 */
public class LeetcodeDemo689 {
    /**
     * dp[i][j]表示考虑前i个数，凑成无重叠子数组数量j个时最大值
     *
     * 状态转移：
     * 如果最优方案包括nums[i],那么nums[i-k+1]~nums[i]不能被前j-1取到
     * dp[i][j] = dp[i-k][j-1]+ nums[i-k+1]+nums[i]
     * 前缀和优化
     *
     * 如果最优方案不包括nums[i]，
     * dp[i][j] = dp[i-1][j]
     *
     *
     * @param nums
     * @param k
     * @return dp[n-1][3]
     */

    //反序DP
    public int[] maxSumOfThreeSubarrays(int[] nums,  int k)
    {
        int n = nums.length;
        //前缀和
        long[] sum = new long[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];

        long[][] dp = new long[n + 10][4];
        for(int i = n - k + 1; i >= 1; i--)
        {
            for(int j = 1; j < 4; j++)
            {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }

        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while(j > 0)
        {
            if (dp[i + 1][j] > dp[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]) {
                i++;
            } else {
                ans[idx++] = i - 1;
                i += k; j--;
            }
        }
        return ans;
    }
}
