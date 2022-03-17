package com.Leetcode;

/**
 * Leetcode567,字符串的排序
 * 滑动窗口
 */
public class LeetcodeDemo567 {
    public static void main(String[] args) {

    }

    public static boolean checkInclusion(String s1, String s2)
    {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        //cnt代表s1词频
        int[] cnt = new int[26];
        for(int i = 0; i < n; i++) cnt[s1.charAt(i) - 'a']++;

        //cur代表s2词频
        int[] cur = new int[26];
        for(int i = 0; i < n; i++) cur[s2.charAt(i) - 'a']++;
        if(check(cnt, cur)) return true;

        for(int i = n; i < m; i++)
        {
            cur[s2.charAt(i) - 'a']++;
            cur[s2.charAt(i - m) - 'a']--;
            if(check(cnt, cur)) return true;
        }
        return false;
    }

    public static boolean check(int[] cnt, int[] cur)
    {
        for(int i = 0; i < 26; i++)
        {
            if(cnt[i] != cur[i]) return false;
        }
        return true;
    }
}
