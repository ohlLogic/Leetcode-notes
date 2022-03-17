package com.Leetcode;

/**
 * Leetcode1208,尽可能使字符串相等
 * 滑动窗口
 */
public class LeetcodeDemo1208 {
    public static void main(String[] args) {
        System.out.println(equalSubstring("abcd", "bcdf", 3));
    }

    public static int equalSubstring(String s, String t, int maxCost)
    {
        int n = s.length();
        int[] abs = new int[n];
        for(int i = 0; i < n; i++) abs[i] = Math.abs(s.charAt(i) - t.charAt(i));

        int l = 0, r = 0;
        int sum = 0, len = 0;
        while(r < n)
        {
            sum += abs[r];

            while(sum > maxCost)
            {
                sum -= abs[l];
                l++;
            }
            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}
