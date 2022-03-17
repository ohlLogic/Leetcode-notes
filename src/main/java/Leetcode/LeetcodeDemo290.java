package com.Leetcode;

/**
 * Leetcode290，单词规律
 * 哈希表
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo290 {
    public boolean wordPattern(String pattern, String s)
    {
        String[] words = s.split(" ");
        int n = words.length;
        if(n != pattern.length()) return false;
        Map<Object, Integer> map = new HashMap<>();
        for(Integer i = 0; i < n; i++)
        {
            if(map.put(pattern.charAt(i), i) != map.put(words[i], i)) return false;
        }

        return true;
    }
}
