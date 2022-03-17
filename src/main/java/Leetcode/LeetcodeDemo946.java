package com.Leetcode;

/**
 * Leetcode946,验证栈序列
 * 模拟
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo946 {
    public boolean validateStackSequence(int[] pushed, int[] popped)
    {
        Deque<Integer> d = new ArrayDeque<>();
        int i = 0;
        for(int num : pushed)
        {
            d.addLast(num);
            while(!d.isEmpty() && d.peekLast() == popped[i])
            {
                d.pollLast();
                i++;
            }
        }
        return d.isEmpty();
    }
}
