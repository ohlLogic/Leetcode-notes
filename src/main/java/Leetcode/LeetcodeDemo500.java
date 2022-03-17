package com.Leetcode;

/**
 * Leetcode500，键盘行
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo500 {
    static String[] ss = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    static Map<Character, Integer> map = new HashMap<>();
    static {
        for (int i = 0; i < ss.length; i++) {
            for (char c : ss[i].toCharArray()) map.put(c, i);
        }
    }
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        out:for (String w : words) {
            int t = -1;
            for (char c : w.toCharArray()) {
                c = Character.toLowerCase(c);
                if (t == -1) t = map.get(c);
                else if (t != map.get(c)) continue out;
            }
            list.add(w);
        }
        return list.toArray(new String[list.size()]);
    }
}
