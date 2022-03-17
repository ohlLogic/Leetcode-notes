package com.Leetcode;

/**
 * Leetcode1009,十进制数的反码
 */
public class LeetcodeDemo1009 {
    public static void main(String[] args) {

    }

    public int bitwiseComplement(int n)
    {
        int highbit = 1;
        int x = n;
        while(x != 0)
        {
            highbit = x & (-x);
            x = x & (x - 1);
        }
        return n ^ ((highbit << 1) - 1);
    }
}
