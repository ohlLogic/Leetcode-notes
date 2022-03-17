package com.Leetcode;

/**
 * Leetoce524,通过删除字母匹配到字典里最长单词
 * 贪心 + 双指针
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetcodeDemo524 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord("abpcplea", list));
    }

    //对集合进行排序，然后双指针
    public static String findLongestWord(String s, List<String> dictionary)
    {
        Collections.sort(dictionary, (a, b) -> {
            if(a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });

        for(String t : dictionary)
        {
            int n = t.length();
            int i = 0, j = 0;
            while(i < n && j < s.length())
            {
                if(t.charAt(i) == s.charAt(j))
                {
                    i++;
                    j++;
                }
                else{
                    j++;
                }
            }
            if(i == n) return t;
        }
        return "";
    }
}
