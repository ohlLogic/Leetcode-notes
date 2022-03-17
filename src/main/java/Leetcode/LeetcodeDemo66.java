package com.Leetcode;

/**
 * Leetcode66，加一
 */
public class LeetcodeDemo66 {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits)
    {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--)
        {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0) return digits;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
