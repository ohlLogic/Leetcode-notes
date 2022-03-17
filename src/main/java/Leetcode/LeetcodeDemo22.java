package com.Leetcode;

/**
 * Leetcode22,括号生成
 */

import java.util.*;

public class LeetcodeDemo22 {

    public List<String> generateParenthesis(int n)
    {
        List<String> res = new ArrayList<>();
        dfs(0, 2 * n, 0, n, "", res);
        return res;
    }

    /**
     *
     * @param i 当前遍历到当前位置
     * @param n 字符总长度
     * @param score 目前得分
     * @param max 最大得分值
     * @param path 当前拼接结果
     * @param res 最终结果集
     */
    public void dfs(int i, int n, int score, int max, String path, List<String> res)
    {
        if(i == n)
        {
            if(score == 0) res.add(path);
            return;
        }

        if(score + 1 <= max) dfs(i + 1, n, score + 1, max, path + "(", res);
        if(score - 1 >= 0) dfs(i + 1, n, score - 1, max, path + ")", res);
    }
}
