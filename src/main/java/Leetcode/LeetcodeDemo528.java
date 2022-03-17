package com.Leetcode;

/**
 * Leetcode528,按权重随机选择
 * 前缀和 + 二分
 */
public class LeetcodeDemo528 {
    int[] sum;
    public static void main(String[] args) {
        int[] w = {1, 3, 4};
        LeetcodeDemo528 ss = new LeetcodeDemo528(w);
        System.out.println(ss.pickIndex());
    }

    public LeetcodeDemo528(int[] w)
    {
        int n = w.length;
        sum = new int[n + 1];
        for(int i = 1; i <= n; i++) sum[i] = sum[i - 1] + w[i - 1];
    }

    public int pickIndex()
    {
        int n = sum.length;
        int t = (int) (Math.random() * sum[n - 1]) + 1;
        int l = 1, r = n - 1;
        while(l < r)
        {
            int mid = l + r >> 1;
            if(sum[mid] >= t) r = mid;
            else l = mid + 1;
        }
        //sum数组比w数组向后滞后1
        return r - 1;
    }
}
