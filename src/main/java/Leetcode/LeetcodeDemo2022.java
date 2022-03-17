package com.Leetcode;

/**
 * Leetcode2022,将一维数组转为二维数组
 * 二维转一维
 */
public class LeetcodeDemo2022 {
    public int[][] construct2DArray(int[] original, int m, int n)
    {
        if(original.length != m * n) return new int[0][0];
        int[][] ans = new int[m][n];

        for(int i = 0; i < original.length; i++) ans[i / n][i % n] = original[i];
        return ans;
    }
}
