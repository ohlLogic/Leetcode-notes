package com.Leetcode;

/**
 * Leetcode274,H指数
 * 二分
 * 引用次数至少为x次的x篇论文中的最大x值
 * 满足二段性
 */

public class LeetcodeDemo274 {
    public static void main(String[] args) {

    }
    public static int hIndex(int[] citations)
    {
        int n = citations.length;
        int l = 0, r = n;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if (check(citations, mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
    public static boolean check(int[] citations, int mid)
    {
        int res = 0;
        for (int citation : citations) {
            if(citation >= mid) res++;
        }
        return res >= mid;
    }
}
