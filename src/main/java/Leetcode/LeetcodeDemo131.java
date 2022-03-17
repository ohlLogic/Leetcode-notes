package com.Leetcode;

/**
 * Leetcode131,分割回文串
 * dfs
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo131 {
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    //dfs+回溯
    public List<List<String>> partition(String s)
    {
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int u)
    {
        if(u == s.length())
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = u; i < s.length(); i++)
        {
            String sub = s.substring(u, i + 1);
            if(check(sub))
            {
                cur.add(sub);
                dfs(s, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public boolean check(String t)
    {
        int n = t.length();
        for(int i = 0; i < n / 2; i++)
        {
            if(t.charAt(i) != t.charAt(n - 1 - i)) return false;
        }
        return true;
    }
}
