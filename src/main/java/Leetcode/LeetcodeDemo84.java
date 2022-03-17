package com.Leetcode;

/**
 * Leetcode84,柱状图中最大的矩形面积
 */

import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Math.max;

public class LeetcodeDemo84 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    //单调递增栈
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> st = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for(int i = 1; i < heights.length + 1; i++) new_heights[i] = heights[i - 1];

        for (int i = 0; i < new_heights.length; i++) {
            while (!st.isEmpty() && new_heights[st.peekFirst()] > new_heights[i]) {
                int cur = st.pollFirst();
                int left = st.peekFirst();
                int right = i;
                res = max(res, (right - left - 1) * new_heights[cur]);
            }
            st.addFirst(i);
        }
        return res;
    }
}
