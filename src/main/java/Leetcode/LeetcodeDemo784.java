package com.Leetcode;

/**
 * Leetcode784, 字母大小全排列
 * DFS
 */

import java.util.*;

public class LeetcodeDemo784 {
    List<String> res = new ArrayList<>();
    int n;

    public List<String> letterCasePermutation(String s) {
        n = s.length();
        dfs(s, 0, "");
        return res;
    }

    public void dfs(String s, int u, String sb) {
        if (u == n) {
            res.add(sb);
            return;
        }

        char c = s.charAt(u);
        if (Character.isLetter(c)) {
            if (Character.isLowerCase(c)) {
                dfs(s, u + 1, sb + c);
                dfs(s, u + 1, sb + Character.toUpperCase(c));
            } else {
                dfs(s, u + 1, sb + Character.toLowerCase(c));
                dfs(s, u + 1, sb + c);
            }
        } else {
            dfs(s, u + 1, sb + c);
        }
    }

    public static void main(String[] args) {
        LeetcodeDemo784 tt = new LeetcodeDemo784();
        System.out.println(tt.letterCasePermutation("C"));
    }
}
