package com.Leetcode;

/**
 * Leetcode1736,替换隐藏数字得到的最晚时间
 * 模拟
 */
public class LeetcodeDemo1736 {
    public static void main(String[] args) {

    }
    public static String maximumTime(String time)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(time.charAt(0) == '?' ? (time.charAt(1) == '?' || time.charAt(1) < '4') ? '2' : '1' : time.charAt(0));
        sb.append(time.charAt(1) == '?' ? sb.charAt(0) == '2' ? '3' : '9' : time.charAt(1));
        sb.append(':');
        sb.append(time.charAt(3) == '?' ? '5' : time.charAt(3));
        sb.append(time.charAt(4) == '?' ? '9' : time.charAt(4));
        return sb.toString();
    }
}
