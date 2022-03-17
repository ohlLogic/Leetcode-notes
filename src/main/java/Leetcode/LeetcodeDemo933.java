package com.Leetcode;
/**
 * Leetcode933,最近的请求次数
 * 队列
 */

import java.util.*;
public class LeetcodeDemo933 {
    class RecentCounter {
        Deque<Integer> d;
        public RecentCounter() {
            d = new ArrayDeque<>();
        }

        public int ping(int t) {
            while(!d.isEmpty() && d.peekFirst() + 3000 < t) d.pollFirst();
            d.addLast(t);
            return d.size();
        }
    }
}
