package com.Leetcode;

import java.util.Stack;

/**
 * Leetcode242,有效的字母异位词
 * 数组映射
 */
public class LeetcodeDemo242 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.pop();
        System.out.println(isAnagram("a", "ab"));
    }

    public static boolean isAnagram(String s, String t)
    {
        int[] tt = new int[26];
        if(t.length() > s.length())
        {
            String temp = t;
            t = s;
            s = temp;
        }

        for(int i = 0; i < t.length(); i++) tt[t.charAt(i) - 'a']++;
        for(int j = 0; j < s.length(); j++)
        {
            if(tt[s.charAt(j) - 'a'] == 0) return false;
            else tt[s.charAt(j) - 'a']--;
        }

        return true;
    }
}
