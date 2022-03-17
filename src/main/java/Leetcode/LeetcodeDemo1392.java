package com.Leetcode;

/**
 * Leetcode1392,最长快乐前缀
 * KMP
 */

import java.util.HashSet;
import java.util.Set;

public class LeetcodeDemo1392 {
    //HashSet,超出内存限制
    public String longestPrefix(String s)
    {
        int n = s.length();
        Set<String> set = new HashSet<>();
        //加入前缀
        for(int i = 1; i < n; i++)
        {
            set.add(s.substring(0, i));
        }

        //判断后缀是否存在
        for(int i = 1; i < n; i++)
        {
            if(set.contains(s.substring(i))) return s.substring(i);
        }
        return "";
    }

    //KMP,找next数组
    public String longestPrefix1(String s)
    {
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0;
        for(int i = 1, j = 0; i < n; i++)
        {
            while(j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];
            if(s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
        return s.substring(0, next[n]);
    }
}
