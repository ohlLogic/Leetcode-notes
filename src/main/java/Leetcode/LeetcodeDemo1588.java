package com.Leetcode;

/**
 * Leetcode1588,所有奇数长度子数组的和
 * 前缀和
 */
public class LeetcodeDemo1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        //计算前缀和数组
        int n = arr.length;
        int[] sum = new int[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + arr[i - 1];

        //枚举l, r
        int ans = 0;
        for(int l = 0; l < n; l++)
        {
            for(int r = l; r < n; r++)
            {
                if((r - l + 1) % 2 == 0) continue;
                ans += sum[r + 1] - sum[l];
            }
        }
        return ans;
    }
}
