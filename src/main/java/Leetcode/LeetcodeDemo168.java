package com.Leetcode;

/**
 * Leetocde168,Excel表列名称
 * 进制模拟
 */
public class LeetcodeDemo168 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
    }
    public static String convertToTitle(int columnNumber)
    {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0)
        {
            columnNumber--;
            sb.append((char)(columnNumber + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
