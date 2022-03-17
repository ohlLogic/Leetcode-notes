package com.Leetcode;

/**
 * Leetocde151,翻转字符串
 * 1.反转字符串
 * 2.反转每个单词
 * 3.首尾空格
 */
public class LeetcodeDemo151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello    world  "));
        System.out.println(reverseWords1("  hello    world  "));
    }

    public static String reverseWords(String s)
    {
        String t = new StringBuffer(s).reverse().toString();
        StringBuffer temp = new StringBuffer();
        String[] tt = t.split("\\s+");
        for(String ss : tt)
        {
            temp.append(new StringBuffer(ss).reverse().toString());
            temp.append(" ");
        }
        return temp.toString().trim();
    }

    //手动模拟实现
    public static String reverseWords1(String s)
    {
       //去掉首尾和字符串中多余空格
       StringBuilder sb = removeSpace(s);

       //反转字符串
        reverseString(sb, 0, sb.length() - 1);

        //反转字符串中的单词
        reverseEach(sb);
        return sb.toString();
    }

    public static void reverseEach(StringBuilder sb) {
        int l = 0, r = 1;
        while(l < sb.length())
        {
            while(r < sb.length() && sb.charAt(r) != ' ') r++;
            reverseString(sb, l, r - 1);
            l = r + 1;
            r = l + 1;
        }
    }

    public static void reverseString(StringBuilder sb, int l, int r) {
        while(l < r)
        {
            char temp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, temp);
            l++;
            r--;
        }
    }

    public static StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int l = 0, r = s.length() - 1;
        //去掉末尾空格
        while(s.charAt(l) == ' ') l++;
        while(s.charAt(r) == ' ') r--;

        while(l <= r)
        {
            char c = s.charAt(l);
            //如果字符串当前位置不为空格或者sb末尾不是空格则假如当前字符
            if(c != ' ' || sb.charAt(sb.length() - 1) != ' ') sb.append(c);
            l++;
        }
        return sb;
    }


}
