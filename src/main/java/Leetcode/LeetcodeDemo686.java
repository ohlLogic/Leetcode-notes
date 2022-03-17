package com.Leetcode;

/**
 * Leetcode686,重复叠加字符串匹配
 * KMP，字符串哈希
 */
public class LeetcodeDemo686 {
    public int repeatedStringMatch(String a, String b)
    {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(sb.length() < b.length() && ++cnt > 0) sb.append(a);
        sb.append(a);

        //idx表示叠加后字符串的起始下标
        int idx = strStr(sb.toString(), b);
        //int idx = strHash(sb.toString(), b);
        if(idx == -1) return -1;
        return idx + b.length() > a.length() * cnt ? cnt + 1 : cnt;
    }

    //KMP
    public int strStr(String ss, String pp)
    {
        if(pp.isEmpty()) return 0;

        int n = ss.length(), m = pp.length();
        //下标从1开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        //构建next数组
        int[] next = new int[m + 1];
        for(int i = 2, j = 0; i <= m; i++)
        {
            //匹配不成功，j=next[j]
            while(j > 0 && p[i] != p[j + 1]) j = next[j];
            //匹配成功
            if(p[i] == p[j + 1]) j++;
            next[i] = j;
        }

        for(int i = 1, j = 0; i <= n; i++)
        {
            //匹配不成功
            while(j > 0 && s[i] != p[j + 1]) j = next[j];
            //匹配成功
            if(s[i] == p[j + 1]) j++;
            if(j == m) return i - m;
        }
        return -1;
    }

    //字符串哈希
    public int strHash(String ss, String b)
    {
        int P = 131;
        int n = ss.length(), m = b.length();
        String str = ss + b;
        int len = str.length();
        int[] h = new int[len + 10], p = new int[len + 10];
        h[0] = 0; p[0] = 1;
        for(int i = 0; i < len; i++)
        {
            p[i + 1] = p[i] * P;
            h[i + 1] = h[i] * P + str.charAt(i);
        }
        int r = len, l = r - m + 1;
        int target = h[r] - h[l - 1] * p[r - l + 1]; // b的哈希值
        for(int i = l; i <= n; i++)
        {
            int j = i + m -1;
            int cur = h[j] - h[i - 1] * p[j - i + 1]; //子串哈希值
            if(cur == target) return i - 1;
        }
        return -1;
    }
}
