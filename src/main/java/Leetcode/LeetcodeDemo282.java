package com.Leetcode;

/**
 * Leetcode282,给表达式添加运算符
 * dfs
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo282 {
    List<String> res = new ArrayList<>();
    int n, t;
    String s;
    public static void main(String[] args) {

    }

    public List<String> addOperators(String num, int target)
    {
        s = num;
        n = s.length();
        t = target;
        dfs(0, 0, 0, "");
        return res;
    }

    public void dfs(int u, long prev, long cur, String ss)
    {
        //保存结果
        if(u == n)
        {
            if(cur == t) res.add(ss);
            return;
        }

        for(int i = u; i < n; i++)
        {
            if(i != u && s.charAt(u) == '0') break;
            long next = Long.parseLong(s.substring(u, i + 1));
            if(u == 0) dfs(i + 1, next, next, "" + next);
            else
            {
                dfs(i + 1, next, cur + next, ss + "+" + next);
                dfs(i + 1, -next, cur - next, ss + "-" + next);
                long x = prev * next;
                dfs(i + 1, x, cur - prev + x, ss + "*" + next);
            }
        }
    }
}
