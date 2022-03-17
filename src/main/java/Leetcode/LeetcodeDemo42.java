package com.Leetcode;

/**
 * Leetcode42,接雨水
 */

import java.util.Stack;

public class LeetcodeDemo42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trap1(height));
        System.out.println(trap2(height));
    }

    /**
     * 动态规划
     *对于第i个柱子，i处能接水的高度 = min(leftheight(i),rightheight(i)) - height(i)
     * 用sum记录每个柱子的接水量++
     *
     * leftheight(i)为第i个柱子左边最高高度
     * leftheight(0) = height[0]
     * 当0 < i < n时，leftheight(i)=max(leftheight(i-1), height(i))
     *
     * rightheight(i)为第i个柱子右边最高高度
     * rightheight(n - 1) = height[n - 1]
     * 当0 <= i < n - 1时，rightheight(i)=max(rightheight(i+1),height(i))
     */
    public static int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int[] leftheight = new int[n];
        int[] rightheight = new int[n];

        leftheight[0] = height[0];
        rightheight[n - 1] = height[n - 1];
        for(int i = 1; i < n; i++) leftheight[i] = Math.max(leftheight[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) rightheight[i] = Math.max(rightheight[i + 1], height[i]);

        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            sum += Math.min(leftheight[i], rightheight[i]) - height[i];
        }
        return sum;
    }

    /**
     * 单调栈
     *
     */
    public static int trap1(int[] height)
    {
        int n = height.length;
        if(n == 0) return 0;

        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && height[st.peek()] < height[i])
            {
                int cur = st.pop();
                if(st.isEmpty()) break;
                int h = Math.min(height[st.peek()], height[i]) - height[cur];
                res += (i - st.peek() - 1) * h;
            }
            st.push(i);
        }
        return res;
    }

    /**
     * 双指针
     */
    public static int trap2(int[] height)
    {
        int l = 0, r = height.length - 1, res = 0;
        int left_max = 0, right_max = 0;
        while(l < r)
        {
            if(height[l] < height[r])
            {
                if(height[l] > left_max) left_max = height[l];
                else res += left_max - height[l];
                l++;
            }else{
                if(height[r] > right_max) right_max = height[r];
                else res += right_max - height[r];
                r--;
            }
        }
        return res;
    }
}
