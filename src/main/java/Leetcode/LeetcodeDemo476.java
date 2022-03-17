package com.Leetcode;

/**
 * Leetcode476,数字的补数
 */
public class LeetcodeDemo476 {
    public static void main(String[] args) {
        System.out.println(5 & (-5));
    }

    public int findComplement(int num)
    {
        int highbit = 1;
        int x = num;
        while(x != 0)
        {
            highbit = x & (-x);
            x = x & (x - 1);
        }
        return num ^ ((highbit << 1) - 1);
    }
}
