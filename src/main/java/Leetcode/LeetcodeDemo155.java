package com.Leetcode;

/**
 * Leetcode155,最小栈
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo155 {
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minstack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minstack = new ArrayDeque<>();
        }

        public void push(int val) {
            if (minstack.isEmpty() || val <= minstack.peekLast()) minstack.addLast(val);
            stack.addLast(val);
        }

        public void pop() {
            int val = stack.pollLast();
            if (val == getMin()) minstack.pollLast();
        }

        public int top() {
            return stack.peekLast();
        }

        public int getMin() {
            return minstack.peekLast();
        }
    }
}
