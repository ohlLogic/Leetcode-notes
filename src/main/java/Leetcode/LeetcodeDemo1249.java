package com.Leetcode;

/**
 * Leetcode1249,移除无效的括号
 * 队列
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo1249 {
    public static void main(String[] args) {
        LeetcodeDemo1249 tt = new LeetcodeDemo1249();
        System.out.println(tt.minRemoveToMakeVaild("())()((("));
    }
    public String minRemoveToMakeVaild(String s)
    {
        Deque<Integer> index = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while(i < s.length())
        {
            char c= s.charAt(i++);
            if(c == '(')
            {
                index.addLast(sb.length());
                sb.append(c);
            }
            else if(c == ')')
            {
                if(!index.isEmpty()) {
                    index.pollLast();
                    sb.append(c);
                }
            }
            else sb.append(c);
        }

        while(!index.isEmpty()) sb.deleteCharAt(index.pollLast());
        return sb.toString();
    }
}
