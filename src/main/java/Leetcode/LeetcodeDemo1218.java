package com.Leetcode;

/**
 * Leetcode1218,最长等差子序列
 * 动态规划
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo1218 {
    public int longestSubsequence(int[] arr, int difference)
    {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        //dp[i][j]表示考虑前i个数，且第i个选择为j时，得到的最长子序列个数
        //res = max(dp[n - 1][0], dp[n - 1][1])

        int[][] dp = new int[n][2];

        /**
         * 状态转移：
         * dp[i][0]表示第i个位置不选，dp[i][0] = max(dp[i - 1][0], dp[i - 1][1])
         *
         * dp[i][1]表示第i个位置选择: 根据前面是否有prev
         * 如果arr[i]单独成为一个序列，dp[i][1] = 1
         * 如果arr[i]与前面某个数prev = arr[i] - difference形成序列
         * dp[i][1] = dp[hash[prev]][1] + 1
         */

        //状态初始化：dp[0][0] = 1, dp[0][1] = 1
        dp[0][1] = 1;
        map.put(arr[0], 0);

        for(int i = 1; i < n; i++)
        {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = 1;
            int prev = arr[i] - difference;
            if(map.containsKey(prev)) dp[i][1] = Math.max(dp[i][1], dp[map.get(prev)][1] + 1);
            map.put(arr[i], i);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    //一维优化
    public int longestSubsequence1(int[] arr, int difference)
    {
        int n = arr.length;

        //定义dp[i]为前i个数时（第i个数必选），得到的最长等差子序列的长度
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;

        for(int i : arr)
        {
            map.put(i, map.getOrDefault(i - difference, 0) + 1);
            res = Math.max(res, map.get(i));
        }
        return res;
    }
}
