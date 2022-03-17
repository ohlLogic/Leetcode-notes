package com.Leetcode;

/**
 *Leetcode2000,反转单词前缀
 * 模拟
 */
public class LeetcodeDemo2000 {
    public String reversePrefix(String word, char ch)
    {
        int idx = -1;
        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == ch)
            {
                idx = i;
                break;
            }
        }

        //反转
        if(idx != -1)
        {
            StringBuilder sb = new StringBuilder();
            for(int i = idx; i >= 0; i--) sb.append(word.charAt(i));
            sb.append(word.substring(idx + 1, word.length()));
            return sb.toString();
        }
        return word;
    }
}
