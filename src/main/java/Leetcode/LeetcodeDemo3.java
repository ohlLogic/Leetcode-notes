package com.Leetcode;

import java.util.HashMap;

/**
 * Leetcode3,无重复字符的最长子串(可变滑动窗口模板)
 */
public class LeetcodeDemo3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s)
    {
        if(s.length() == 0) return 0;


        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int max = 0;
        for(; r < s.length(); r++)
        {
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r)) + 1);
            }

            map.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);

        }
        return max;
    }
}
