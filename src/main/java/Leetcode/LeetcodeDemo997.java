package com.Leetcode;

/**
 * Leetcode997,找到小镇的法官
 * 图论
 */
public class LeetcodeDemo997 {
    public int findJudge(int n, int[][] trust)
    {
        //存放每个人的信任值
        int[] trustvalue = new int[n + 1];

        for(int[] t : trust)
        {
            trustvalue[t[0]]--;
            trustvalue[t[1]]++;
        }

        //遍历n个人的信任值，如果存在n-1，那么这个人就是法官
        for(int i = 1; i <= n; i++)
        {
            if(trustvalue[i] == n - 1) return i;
        }
        return -1;
    }
}
