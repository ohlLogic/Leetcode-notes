package com.Leetcode;

/**
 * Leetcode1763,最长的美好子字符串
 *
 */
public class LeetcodeDemo1763 {
    //暴力枚举
    public String longestNiceSubstring(String s)
    {
        int n = s.length();
        String res = "";
        for(int i = 0; i < n; i++)
        {
            out:for(int j = i + 1; j < n; j++)
            {
                String sub = s.substring(i, j + 1);
                if(sub.length() > res.length())
                {
                    for(char c : sub.toCharArray())
                    {
                        char lo = Character.toLowerCase(c), up = Character.toUpperCase(c);
                        if(sub.indexOf(lo) < 0 || sub.indexOf(up) < 0) continue out;
                    }
                    res = sub;
                }
            }
        }
        return res;
    }

    //前缀和优化
    public String longestNiceSubstring1(String s)
    {
        int n = s.length();
        int[][] cnt = new int[n + 1][128];
        for(int i = 1; i <= n; i++)
        {
            char c = s.charAt(i - 1);
            cnt[i] = cnt[i - 1].clone();
            cnt[i][c - 'A']++; //'A' = 65
        }

        int idx = -1, len = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(j - i + 1 <= len) continue;
                int[] a = cnt[i], b = cnt[j + 1];
                if(check(a, b))
                {
                    idx = i; len = j - i + 1;
                }
            }
        }
        return idx == -1 ? "" : s.substring(idx, idx + len);
    }

    public boolean check(int[] a, int[] b)
    {
        for(int i = 0; i < 26; i++)
        {
            int low = b[i] - a[i], up = b[i + 32] - a[i + 32];
            if(low != 0 && up == 0) return false;
            if(low == 0 && up != 0) return false;
        }
        return true;
    }
}
