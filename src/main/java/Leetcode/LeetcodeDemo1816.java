package com.Leetcode;

/**
 * Leetcode1816,截断句子
 *
 */
public class LeetcodeDemo1816 {
    public String truncateSentence(String s, int k)
    {
        //找到k+1空格
        int cnt = 0;
        int i = 0;
        for(; i < s.length(); i++)
        {
            if(s.charAt(i) == ' ') cnt++;
            if(cnt == k) break;
        }

        return s.substring(0, i);
    }
}
