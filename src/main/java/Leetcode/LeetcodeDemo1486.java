package com.Leetcode;

/**
 * Leetcode1486,数组异或操作
 */
public class LeetcodeDemo1486 {
    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }
    public static int xorOperation(int n, int start)
    {
        int res = start;
        for(int i = 1; i < n; i++) res ^=  start + 2 * i;
        return res;
    }
}
