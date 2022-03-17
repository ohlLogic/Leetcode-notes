package com.Leetcode;

/**
 * Leetcode125,验证回文串
 *
 */
public class LeetcodeDemo125 {
    public boolean isPalindrome(String s)
    {
        if(s.equals("")) return true;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetter(ch)) sb.append(Character.toLowerCase(ch));
            if(Character.isDigit(ch)) sb.append(ch);
        }

        int n = sb.length();
        int l = 0, r = n - 1;
        while(l < r)
        {
            if(sb.charAt(l) != sb.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
