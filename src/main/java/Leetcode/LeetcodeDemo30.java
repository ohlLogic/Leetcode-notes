package com.Leetcode;

/**
 * Leetcode30,串联所有单词的子串
 * 滑动窗口+哈希表
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo30 {
    public static void main(String[] args) {
        String[] words = {"fooo","barr", "wing", "ding", "wing"};
        System.out.println(findSubstring("lingmind", words));
    }

    public static List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> list = new ArrayList<>();
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        //统计word词频
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        //滑动窗口词频
        for(int i = 0; i < w; i++)
        {
            Map<String, Integer> curmap = new HashMap<>();
            for(int j = i; j + w <= n; j += w)
            {
                String cur = s.substring(j, j + w);

                //如果当前单词超过滑动窗口大小，需要缩短左区间，扩张右区间
                if(j >= i + w * m)
                {
                    //判断当前单词在curmap是否只有一个，如果只有一个，在curmap删除，否则数量减一
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if(curmap.get(prev) == 1) curmap.remove(prev);
                    else curmap.put(prev, curmap.get(prev) - 1);
                }
                //加入当前右扩张单词
                curmap.put(cur, curmap.getOrDefault(cur, 0) + 1);
                if(map.containsKey(cur) && curmap.get(cur).equals(map.get(cur)) && cmp(map, curmap)) list.add(j - (m - 1) * w);
            }
        }

        return list;
    }

    public static boolean cmp(Map<String, Integer> map, Map<String, Integer> curmap)
    {
        if(map.size() != curmap.size()) return false;
        for(String k1 : map.keySet())
        {
            //curmap中没有map的key或者curmap中key对应的value不等于map中key对应的value，return false
            if(!curmap.containsKey(k1) || !map.get(k1).equals(curmap.get(k1))) return false;
        }
        for(String k2 : curmap.keySet())
        {
            if(!map.containsKey(k2) || !curmap.get(k2).equals(map.get(k2))) return false;
        }
        return true;
    }
}
