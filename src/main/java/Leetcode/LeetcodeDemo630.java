package com.Leetcode;

/**
 * Leetcode630, 课程表3
 * 贪心 + 大根堆
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetcodeDemo630 {
    public int scheduleCourse(int[][] courses)
    {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        //大根堆
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        int tol = 0;
        for(int[] course : courses)
        {
            int ti = course[0], di = course[1];
            if(tol + ti <= di)
            {
                tol += ti;
                q.offer(ti);
            }
            else if(!q.isEmpty() && q.peek() > ti)
            {
                tol -= q.poll() - ti;
                q.offer(ti);
            }
        }
        return q.size();
    }
}
