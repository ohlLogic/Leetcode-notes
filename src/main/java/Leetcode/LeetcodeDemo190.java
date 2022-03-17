package com.Leetcode;

/**
 * Leetcode190,颠倒二进制位
 * 位运算
 */
public class LeetcodeDemo190 {
    public static void main(String[] args) {

    }

    public static int reverseBits(int n)
    {
        int res = 0;
        for(int i = 0; i < 32; i++)
        {
            int end = (n >> i) & 1;
            if(end == 1) res |= (1 << (31 - i));
        }
        return res;
    }
}
