package com.Leetcode;

/**
 * Leetcode424,替换后的最长重复字符
 * 滑动窗口
 */
public class LeetcodeDemo424 {
    public static void main(String[] args) {
        System.out.println(charaterReplacement("AABABBA", 1));
        System.out.println(charaterREplacement1("AABABBA", 1));
    }

    public static int charaterReplacement(String s, int k)
    {
        int[] cnt = new int[26];

        int l = 0, r = 0;
        int res = 0, n = s.length();

        while(r < n)
        {
            cnt[s.charAt(r) - 'A']++;
            while(!check(cnt, k)) {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

    public static boolean check(int[] cnt, int k)
    {
        int max = 0, sum = 0;
        for(int i = 0; i < 26; i++)
        {
            max = Math.max(max, cnt[i]);
            sum += cnt[i];
        }

        return sum - max <= k;
    }

    public static int charaterREplacement1(String s, int k)
    {
        int n = s.length(), l = 0, r = 0;
        int history = 0, res = 0;
        int[] cnt = new int[26];

        while(r < n)
        {
            cnt[s.charAt(r) - 'A']++;
            history = Math.max(history, cnt[s.charAt(r) - 'A']);
            if(r - l + 1 > history + k)
            {
                cnt[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
