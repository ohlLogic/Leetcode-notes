package com.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Leetcode1047,删除字符串中的所有相邻重复项
 * 栈
 */
public class LeetcodeDemo1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1("abbaca"));
    }

    //系统自带栈
    public static String removeDuplicates(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(stack.peekLast() != null && stack.peekLast() == s.charAt(i)) stack.pollLast();
            else stack.offerLast(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pollLast());
        }

        return sb.reverse().toString();
    }

    //数组模拟栈
    public static String removeDuplicates1(String s)
    {
        char[] st = new char[s.length()];
        int hh = 0, tt = -1;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(hh <= tt && st[tt] == c) tt--;
            else st[++tt] = c;
        }
        return new String(st, 0, tt + 1);
    }
}
