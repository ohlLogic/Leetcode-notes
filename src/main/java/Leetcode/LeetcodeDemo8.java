package com.Leetcode;

/**
 * Leetcode8,字符串转整数
 * 模拟
 */

public class LeetcodeDemo8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 987"));
    }

    public static int myAtoi(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int idx = 0;

        while(idx < n && chars[idx] == ' ') idx++;
        if(idx == n) return 0;

        boolean neg = false;
        if(chars[idx] == '-')
        {
            idx++;
            neg = true;
        }
        else if(chars[idx] == '+') idx++;
        else if(!Character.isDigit(chars[idx])) return 0;

        int res = 0;
        while(idx < n && Character.isDigit(chars[idx]))
        {
            int cur = chars[idx++] - '0';
            //防止溢出，res * 10 + cur > Integer.MAX_VALUE等价变形
            if(res > (Integer.MAX_VALUE - cur) / 10) return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + cur;
        }
        return neg ? -res : res;
    }
}
