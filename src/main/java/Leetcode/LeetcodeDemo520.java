package com.Leetcode;

/**
 * Leetcode520,检测大写字母
 */
public class LeetcodeDemo520 {
    public boolean detectCapitalUse(String word)
    {
        int cnt = 0, n = word.length();
        for(int i = 0; i < n; i++)
        {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') cnt++;
        }

        if(cnt == 0) return true;
        else if(cnt == n) return true;
        else if(cnt == 1 && (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z')) return true;
        return false;
    }
}
