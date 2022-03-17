package com.Leetcode;

/**
 * Leetcode748,最短补全词
 * 模拟
 */
public class LeetcodeDemo748 {
    public String shortestCompletingWord(String licensePlate, String[] words)
    {
        //统计licensePlate字符词频
        int[] cnt = new int[26];
        for(int i = 0; i < licensePlate.length(); i++)
        {
            char ch = licensePlate.charAt(i);
            if(ch == ' ' || Character.isDigit(ch)) continue;
            if(Character.isUpperCase(ch)) cnt[ch - 'a' + 32]++;
            else cnt[ch - 'a']++;
        }

        String ans = null;
        int len = 1002;
        for(String s : words)
        {
            if(check(s, cnt))
            {
                if(s.length() < len)
                {
                    ans = s;
                    len = s.length();
                }
            }
        }
        return ans;
    }


    public boolean check(String s, int[] cnt)
    {
        int[] temp = cnt.clone();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            temp[c - 'a']--;
        }

        for(int i = 0; i < 26; i++)
        {
            if(temp[i] > 0) return false;
        }
        return true;
    }
}
