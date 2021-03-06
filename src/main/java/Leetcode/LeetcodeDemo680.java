package com.Leetcode;

/**
 * Leetcode680,验证回文字符串2
 * 双指针
 */
public class LeetcodeDemo680 {
    public boolean validPalindrome(String s)
    {
        int l = 0, r = s.length() - 1;
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r)) return check(s, l + 1, r) || check(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }

    public boolean check(String s, int l, int r)
    {
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
