package com.Leetcode;

/**
 * Leetcode917,仅仅反转字母
 * 双指针
 */
public class LeetcodeDemo917 {
    public String reverseOnlyLetters(String s)
    {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0, r = n - 1;
        //双指针l, r分别从左，右两边，当遇到英文字母进行交换
        while(l < r)
        {
            while(l < r && !Character.isLetter(cs[l])) l++;
            while(l < r && !Character.isLetter(cs[r])) r--;
            //swap
            char temp = cs[l];
            cs[l] = cs[r];
            cs[r] = temp;
            l++; r--;
        }
        return String.valueOf(cs);
    }
}
