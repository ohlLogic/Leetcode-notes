package com.Leetcode;

/**
 * Leetcode409,最长回文串
 * 哈希表
 */
public class LeetcodeDemo409 {
    public int longestPalindrome(String s)
    {
        int[] cnt = new int[60];
        int i = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c <= 'z' && c >= 'a') cnt[c - 'a']++;
            else cnt[c - 'A' + 26]++;
            i++;
        }

        int res = 0;
        boolean tag = false;
        for(int j = 0; j < 60; j++)
        {
            if(cnt[j] % 2 == 0) res += cnt[j];
            else{
                tag = true;
                res += cnt[j] / 2 * 2;
            }
        }
        return tag ? res + 1 : res;
    }
}
