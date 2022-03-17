package com.Leetcode;

/**
 * LeetCode28: 字符串匹配问题
 */
public class LeetcodeDemo28 {
    public static void main(String[] args) {
        System.out.println(strStr1("hello", "ll"));
        System.out.println(strStr1("aaaaa", "bba"));
        System.out.println("hello".indexOf("ll"));
        System.out.println("aaaaa".indexOf("bba"));
    }


    //暴力匹配
    public static int strStr(String a, String b) {
        if (a == null || b == null) return 0;

        int n = a.length(), m = b.length();
        boolean flag = true;
        for (int i = 0; i <= n - m; i++) {
            flag = true;
            for (int j = 0; j < m; j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                return i;
            }
        }
        return -1;
    }

    public static void GetNext(int[] next, String b)
    {
        next[0] = 0;
        for(int i = 1, j = 0; i < b.length(); i++)
        {
            while(j > 0 && b.charAt(i)!= b.charAt(j))
            {
                j = next[j - 1];
            }
            if(b.charAt(i) == b.charAt(j)) j++;
            next[i] = j;
        }
    }
    //KMP算法
    public static int strStr1(String a, String b)
    {
        if(b.isEmpty()) return 0;

        int[] next = new int[b.length()];

        GetNext(next, b);
        for(int i = 0, j = 0; i < a.length(); i++)
        {
            while(j > 0 && a.charAt(i) != b.charAt(j)) j = next[j - 1];

            if(a.charAt(i) == b.charAt(j)) j++;
            if(j == b.length()) return i - b.length() + 1;
        }
        return -1;
    }
}