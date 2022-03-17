package com.Leetcode;

/**
 * Leetcode953,验证外星词典序
 * 模拟
 */
public class LeetcodeDemo953 {
        public boolean isAlienSorted(String[] words, String order)
    {
        //建立字典序，map下标代表当前字符，map[i]代表先后顺序
        int[] map = new int[26];
        for(int i = 0; i < 26; i++) map[order.charAt(i) - 'a'] = i;

        int n = words.length;
        for(int i = 1; i < n; i++)
        {
            if(!check(words[i - 1], words[i], map)) return false;
        }
        return true;
    }

    public boolean check(String a, String b, int[] map)
    {
        int i = 0, j = 0;
        //相同字符直接跳过
        while(i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j))
        {
            i++;
            j++;
        }

        //当未遍历完
        if(i < a.length() && j < b.length())
        {
            return map[a.charAt(i) - 'a'] < map[b.charAt(j) - 'a'];
        }

        //某两个字符串已经遍历完
        if(i == a.length() && j == b.length()) return true;

        if(i == a.length()) return true;
        return false;
    }
}
