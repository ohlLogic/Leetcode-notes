package com.Leetcode;

/**
 * Leetcode150,逆波兰表达式
 * 栈
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo150 {
    public int evalRPN(String[] tokens)
    {
        Deque<Integer> d = new ArrayDeque<>();
        for(String s : tokens)
        {
            if("+-*/".contains(s))
            {
                int b = d.pollLast(), a = d.pollLast();
                d.addLast(getNum(a, b, s.charAt(0)));
            }
            else d.addLast(Integer.parseInt(s));
        }
        return d.pollLast();
    }

    public int getNum(int a, int b, char ch)
    {
        //加法
        if(ch == 43) return a + b;
        //减法
        if(ch == 45) return a - b;
        //乘法
        if(ch == 42) return a * b;
        //除法
        if(ch == 47) return a / b;
        return -1;
    }
}
