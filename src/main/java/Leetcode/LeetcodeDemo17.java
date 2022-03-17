package com.Leetcode;

/**
 * Leetcode17,电话号码的字母组合
 * 回溯法
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetcodeDemo17 {
    public static void main(String[] args) {
        LeetcodeDemo17 tt = new LeetcodeDemo17();
        System.out.println(tt.letterCombinations("23"));
    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int n;
    Map<String, String[]> map = new HashMap<>(){{
        put("2", new String[]{"a", "b", "c"});
        put("3", new String[]{"d", "e", "f"});
        put("4", new String[]{"g", "h", "i"});
        put("5", new String[]{"j", "k", "l"});
        put("6", new String[]{"m", "n", "o"});
        put("7", new String[]{"p", "q", "r", "s"});
        put("8", new String[]{"t", "u", "v"});
        put("9", new String[]{"w", "x", "y", "z"});
    }};
    public List<String> letterCombinations(String digits)
    {
        n = digits.length();
        if(n == 0) return res;
        dfs(digits, 0);
        return res;
    }

    void dfs(String s, int i)
    {
        if(i == n)
        {
            res.add(sb.toString());
            return;
        }

        String key = s.substring(i, i + 1);
        String[] all = map.get(key);
        for(String item : all)
        {
            sb.append(item);
            dfs(s, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
