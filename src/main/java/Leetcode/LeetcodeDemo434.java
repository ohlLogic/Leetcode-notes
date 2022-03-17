package com.Leetcode;

/**
 * Leetcode434,字符串中的单词数
 * 双指针
 */
public class LeetcodeDemo434 {
    public static void main(String[] args) {
        System.out.println(countSegments("a"));
    }

    public static int countSegments(String s)
    {
        int count = 0, n = s.length();
        int i = 0;
        while(i < n && s.charAt(i) == ' ') i++;
        int j = i;

        while(i < n)
        {
            while(i < n && s.charAt(i) != ' ') i++;
            if(i - j >= 1) count++;
            while(i < n && s.charAt(i) == ' ') i++;
            j = i;
        }
        return count;
    }
}
