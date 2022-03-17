package com.Leetcode;

/**
 * Leetcode557,反转字符串中的单词3
 *
 */
public class LeetcodeDemo557 {
    public String reverseWords(String s)
    {
        String[] ss = s.split(" \\s+");
        StringBuilder sb = new StringBuilder();
        for(String word : ss)
        {
            sb.append(reverse(word) + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public String reverse(String s)
    {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length - 1;
        while(l < r)
        {
            char ch = cs[l];
            cs[l] = cs[r];
            cs[r] = ch;
            l++;
            r--;
        }
        return String.valueOf(cs);
    }
}
