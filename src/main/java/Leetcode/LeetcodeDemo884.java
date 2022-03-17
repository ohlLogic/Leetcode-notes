package com.Leetcode;

/**
 * Leetcode884,两句话中的不常见单词
 * 哈希表
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo884 {
    public String[] uncommonFromSentences(String s1, String s2)
    {
        Map<String, Integer> map = new HashMap<>();
        String str = s1 + " " + s2;
        String[] ss = str.split(" ");

        for(String s : ss) map.put(s, map.getOrDefault(s, 0) + 1);
        List<String> list = new ArrayList<>();
        for(String s : map.keySet())
        {
            if(map.get(s) == 1) list.add(s);
        }
        return list.toArray(new String[list.size()]);
    }
}
