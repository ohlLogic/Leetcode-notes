package com.Leetcode;

/**
 * Leetcode345,反转字符串中的元音字母
 * 双指针模拟
 */
public class LeetcodeDemo345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }

    //双指针
    public static String reverseVowels(String s)
    {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int i = 0, j = n - 1;
        while(i < j)
        {
            while(i < j && check(chars[i])) i++;
            while(i < j && check(chars[j])) j--;
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public static boolean check(char i)
    {
        if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u' || i == 'A' || i == 'E' || i == 'I' || i == 'O' || i == 'U') return false;
        else return true;
    }
}
