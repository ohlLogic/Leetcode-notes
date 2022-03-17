package com.Leetcode;

/**
 * Leetcode187,重复的DNA序列
 * 滑动窗口+哈希表
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo187 {
    public static void main(String[] args) {

    }

    //暴力，滑动窗口
    public static List<String> findRepeateDnaSequences(String s)
    {
        List<String> list = new ArrayList<>();
        int n =s.length();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i + 10 <= n; i++)
        {
            String cur = s.substring(i, i + 10);
            int cnt = map.getOrDefault(cur, 0);
            if(cnt == 1) list.add(String.valueOf(cur));
            map.put(cur, cnt + 1);
        }
        return list;
    }

}
