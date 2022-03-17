package com.Leetcode;

/**
 * Leetcode318,最大单词长度乘积
 * 位运算
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo318 {
    public int maxProduct(String[] words)
    {
        int n = words.length, idx = 0;
        int[] makes = new int[n];
        for(String w : words)
        {
            int t = 0;
            for(int i = 0; i < w.length(); i++)
            {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            makes[idx++] = t;
        }

        int ans = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if((makes[i] & makes[j]) == 0)  ans = Math.max(ans, words[i].length() * words[j].length());
            }
        }
        return ans;
    }

    public int maxProduct1(String[] words)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0, m = w.length();
            for (int i = 0; i < m; i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < m) map.put(t, m);
        }
        int ans = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0) ans = Math.max(ans, map.get(a) * map.get(b));
            }
        }
        return ans;
    }
}
