package com.Leetcode;

/**
 * Leetcode438,找到字符串中所有字母异位词
 * 滑动窗口
 */

import java.util.ArrayList;
import java.util.List;

public class LeetcodeDemo438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt1 = new int[26], cnt2 = new int[26];
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        if (s.length() < n) return res;
        for (int i = 0; i < n; i++) cnt2[p.charAt(i) - 'a']++;

        //将n个字符放入cnt1
        int r = 0;
        while (r < n) {
            cnt1[s.charAt(r) - 'a']++;
            r++;
        }

        int l = 0;
        while (r <= s.length()) {
            if (check(cnt1, cnt2)) res.add(l);
            if (r == s.length()) break;
            cnt1[s.charAt(r) - 'a']++;
            cnt1[s.charAt(l) - 'a']--;
            r++;
            l++;
        }
        return res;
    }

    public boolean check(int[] cnt1, int[] cnt2)
    {
        for(int i = 0; i < 26; i++)
        {
            if(cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
}
