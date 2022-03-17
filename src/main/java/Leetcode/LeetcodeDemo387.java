package com.Leetcode;

/**
 * Leetcode387,字符串中的第一个唯一字符
 * 数组映射，哈希表
 */
public class LeetcodeDemo387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    //数组映射
    public static int firstUniqChar(String s)
    {
        int[] tt = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++) tt[s.charAt(i) - 'a']++;
        for(int i = 0; i < n; i++)
        {
            if(tt[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}
