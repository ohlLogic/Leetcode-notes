package com.Leetcode;

/**
 * Leetcode809,情感丰富的文字(多进制加法模板)
 * 判断条件：
 * 当cout1 < cout2时，说明s字符串小于word字符串，word字符串一定不可扩张为S字符串
 * 当cout1 < 3 && cout1 != cout2时，说明S字符串中存在相同字符子串数量小于3，如果此时S字符串和word字符串
 * 当前字符不相同，说明不可扩张
 */
public class LeetcodeDemo809 {
    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(expressWords(s, words));
    }

    public static int expressWords(String s, String[] words) {
        if (words.length == 0) return 0;

        int sum = 0;
        for (String word : words) {
            int i = 0, j = 0;
            while (i < s.length() && j < word.length()) {
                int cout1 = 0, cout2 = 0;
                char schar = s.charAt(i);
                char wchar = word.charAt(j);
                if (schar != wchar) break;
                while (i < s.length() && s.charAt(i) == schar) {
                    cout1++;
                    i++;
                }
                while (j < word.length() && word.charAt(j) == wchar) {
                    cout2++;
                    j++;
                }
                if (cout1 < cout2) break;
                if (cout1 < 3 && cout1 != cout2) break;
                if (j == word.length() && i == s.length()) sum++;
            }
        }
        return sum;
    }
}
