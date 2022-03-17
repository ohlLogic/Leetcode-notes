package com.Leetcode;

/**
 * Leetcode400,第N位数字
 */
public class LeetcodeDemo400 {
    public int findNthDigit(int n)
    {
        int len = 1;
        while(len * 9 * Math.pow(10, len - 1) < n)
        {
            n -= len * 9 * Math.pow(10, len - 1);
            len++;
        }

        long s = (long) Math.pow(10, len - 1);
        long x = n / len - 1 + s;
        n -= (x - s + 1) * len;
        return n == 0 ? (int) (x % 10) : (int) ((x + 1) / (int) (Math.pow(10, len - n)) % 10);
    }
}
