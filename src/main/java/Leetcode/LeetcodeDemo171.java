package com.Leetcode;

/**
 * Leetcode171,Excel表序列号
 * 模拟
 *
 */
public class LeetcodeDemo171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }

    public static int titleToNumber(String columnTitle)
    {
        int sum = 0;
        int k = 0;
        while(k < columnTitle.length())
        {
            sum += columnTitle.charAt(k++) - 'A' + 1;
            if(k == columnTitle.length()) break;
            sum *= 26;
        }
        return sum;
    }
}
