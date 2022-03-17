package com.Leetcode;

/**
 * Leetcode,赎金信
 */
public class LeetcodeDemo383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine)
    {
        int[] tt = new int[26];
        for(int i = 0; i < magazine.length(); i++) tt[magazine.charAt(i) - 'a']++;
        for(int i = 0; i < ransomNote.length(); i++)
        {
            if(tt[ransomNote.charAt(i) - 'a'] != 0) tt[ransomNote.charAt(i) - 'a']--;
            else return false;
        }
        return true;
    }
}
