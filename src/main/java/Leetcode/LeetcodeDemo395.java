package com.Leetcode;

import java.util.Arrays;

public class LeetcodeDemo395 {
    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc", 2));
        System.out.println(longestSubstring1("ababbc", 2));
    }

    //滑动窗口
    public static int longestSubstring(String s, int k)
    {
        int res = 0;
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for(int p = 1; p <= 26; p++)
        {
            Arrays.fill(cnt, 0);
            //tot代表[j,i]区间字符总数量，sum代表达标字符数量
            for(int i = 0, j = 0, tot = 0, sum = 0; i < n; i++)
            {
                int u = cs[i] - 'a';
                cnt[u]++;
                //如果当前加入字符为1，更新tot
                if(cnt[u] == 1) tot++;
                //如果当前加入字符达标，更新sum
                if(cnt[u] == k) sum++;

                //当前区间[j,i]中字符数量tot超过枚举数量，需要缩短滑动窗口，让j指针后移
                while(tot > p)
                {
                    int c = cs[j++] - 'a';
                    cnt[c]--;
                    //如果cnt[c]==0，需要更新tot
                    if(cnt[c] == 0) tot--;
                    //如果cnt[c] < k，则不达标，需要更新sum
                    if(cnt[c] == k - 1) sum--;
                }
                if(tot == sum) res = Math.max(res, i - j + 1);
            }
        }
        return res;
    }

    //分治+递归
    public static int longestSubstring1(String s, int k)
    {
        int n = s.length();
        if(n < k) return 0;

        int[] cnt = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs) cnt[c - 'a']++;

        for(int i = 0; i < n; i++)
        {
            if(cnt[s.charAt(i) - 'a'] < k)
            {
                int res = 0;
                for(String t : s.split(String.valueOf(s.charAt(i))))
                {
                    res = Math.max(res, longestSubstring1(t, k));
                }
                return res;
            }
        }
        return n;
    }
}
