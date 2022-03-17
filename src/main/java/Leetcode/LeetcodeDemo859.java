package com.Leetcode;

/**
 * Leetcode859,亲密字符串
 */
public class LeetcodeDemo859 {
    public boolean buddyStrings(String s, String goal)
    {
        int n = s.length(), m = goal.length();
        if(n != m) return false;

        int[] cnt1 = new int[26], cnt2 = new int[26];
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            int a = s.charAt(i) - 'a', b = goal.charAt(i) - 'a';
            cnt1[a]++; cnt2[b]++;
            if(a != b) sum++;
        }

        boolean flag = false;
        for(int i = 0; i < 26; i++)
        {
            if(cnt1[i] != cnt2[i]) return false;
            if(cnt1[i] > 1) flag = true;
        }
        return sum == 2 || (sum == 0 && flag);
    }
}
