package com.Leetcode;

/**
 * Leetcode58:字符串中最后一个单词长度
 */
public class LeetcodeDemo58 {
    public static void main(String[] args) {
        String s = "Hello world";

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s)
    {
        String[] strs = s.split("\\s");
        return strs[strs.length - 1].length();
    }

    public static int lengthOfLastWord1(String s)
    {
        int end = s.length() - 1;
        while(end > 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }


}
