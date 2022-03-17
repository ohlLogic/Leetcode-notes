package com.Leetcode;

/**
 * Leetcode231,2的幂
 */
public class LeetcodeDemo231 {
    public boolean isPowerOfTwo(int n)
    {
        //溢出情况
        return n > 0 && (n & (n - 1)) == 0;
    }
}
