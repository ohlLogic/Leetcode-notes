package com.Leetcode;

/**
 * Leetcode49,字符异位词分组
 * 哈希表
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            int[] cnt = new int[26];
            for (int j = 0; j < str.length(); j++) cnt[str.charAt(j) - 'a']++;

            //将每个出现字符大于0拼接在一起组成哈希表的key
            sb.delete(0, sb.length());

            for (int k = 0; k < 26; k++) {
                if (cnt[k] != 0) sb.append((char) k + 'a').append(cnt[k]);
            }

            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
