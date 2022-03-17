package com.Leetcode;

/**
 * Leetcode709,转换成小写字母
 */
public class LeetcodeDemo709 {
    public String toLowerCase(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)) ch |= 32;
            sb.append(ch);
        }
        return sb.toString();
    }
}
