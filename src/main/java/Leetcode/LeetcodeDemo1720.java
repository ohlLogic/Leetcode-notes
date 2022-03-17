package com.Leetcode;

/**
 * Leetcode1720,解码异或后的数组
 */
public class LeetcodeDemo1720 {
    public static void main(String[] args) {

    }

    public static int[] decode(int[] encoded, int first)
    {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;

        for(int i = 1; i < encoded.length + 1; i++)
        {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }
}
