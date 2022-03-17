package com.Leetcode;

import java.util.Arrays;

public class LeetcodeDemo354 {
    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(maxEnvelopes(envelopes));
        System.out.println(maxEnvelopes1(envelopes));
    }

    /**
     * 动态规划，先对信封的宽度进行排序
     * 定义dp[i]表示以第i封信结尾(包含第i封信)最大套娃数量
     *
     * 初始状态
     * dp[i]至少为1
     *
     * 状态转移
     * dp[i] = max(dp[j] + 1, dp[i]) (0<= j < i)
     */

    public static int maxEnvelopes(int[][] envelopes)
    {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];

        int res = 1;
        for(int i = 0; i < n; i++)
        {
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--)
            {
                if(check(envelopes, i, j)) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static boolean check(int[][] envelopes, int i, int j)
    {
        return envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1];
    }

    //动态规划 + 二分
    public static int maxEnvelopes1(int[][] envelopes)
    {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        //dp[i]表示以i结尾的最大值
        int[] dp = new int[n];
        //g[i]表示长度为i的最长上升子序列的最小信封高度
        int[] g = new int[n];
        //取min，用充分大的数进行初始化
        Arrays.fill(g, Integer.MAX_VALUE);
        g[0] = 0;

        int res = 1;
        //len记录当前记录到的最大高度,就是0<= j < i - 1. len = (0, ...,j) + 1
        for(int i = 0, j = 0, len = 1; i < n; i++)
        {
            //对于宽度相同的信封不进行更新
            if(envelopes[i][0] != envelopes[j][0])
            {
                while(j < i)
                {
                    //pre代表以j结尾的最大值，cur表示j的高度
                    int pre = dp[j], cur = envelopes[j][1];
                    if(pre == len) g[len++] = cur;
                    else g[pre] = Math.min(g[pre], cur);
                    j++;
                }
            }

            //二分过程
            int l = 0, r = len;
            while(l < r)
            {
                int mid = l + r >> 1;
                if(envelopes[i][1] <= g[mid]) r = mid;
                else l = mid + 1;
            }

            dp[i] = l;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
