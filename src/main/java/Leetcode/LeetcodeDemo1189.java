package com.Leetcode;

/**
 * Leetcode1189,“气球”的最大数量
 * 模拟
 */
public class LeetcodeDemo1189 {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        for(int i = 0; i < text.length(); i++)
        {
            cnt[text.charAt(i) - 'a']++;
        }

        //a
        int ans = cnt[0];
        //b
        ans = Math.min(ans, cnt['b' -'a']);
        //l
        ans = Math.min(ans, cnt['l' - 'a'] / 2);
        //o
        ans = Math.min(ans, cnt['o' - 'a'] / 2);
        //n
        ans = Math.min(ans, cnt['n' - 'a']);
        return ans;
    }
}
