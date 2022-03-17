package com.Leetcode;

/**
 * Leetcode739,每日温度
 * 单调栈
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo739 {
    public int[] dailyTemperatures(int[] temperatures)
    {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<int[]> d = new ArrayDeque<>();

        for(int i = n - 1; i >= 0; i--)
        {
            int cur = temperatures[i];
            //如果当前元素大于栈顶元素，出栈
            while(!d.isEmpty() && cur >= d.peekLast()[0]) d.pollLast();
            //当前元素小于栈顶元素，说明栈顶元素是当前元素的向后最大一位
            if(!d.isEmpty() && cur < d.peekLast()[0]) ans[i] = d.peekLast()[1] - i;
            if(d.isEmpty()) ans[i] = 0;
            d.addLast(new int[]{cur, i});
        }
        return ans;
    }

    public int[] dailyTemperatures1(int[] temperatures)
    {
        int n = temperatures.length;
        //单调递减栈
        Deque<Integer> d = new ArrayDeque<>();
        int[] ans = new int[n];
        int i = 0;
        while(i < n)
        {
            //当栈为空，或者当前元素小于等于栈顶元素，入栈
            if(d.isEmpty() || temperatures[d.peekLast()] >= temperatures[i]) d.addLast(i++);
            else{
                //如果当前预算大于栈顶元素，说明找到比栈顶元素更好的温度
                Integer top = d.pollLast();
                ans[top] = i - top;
            }
        }
        return ans;
    }
}
