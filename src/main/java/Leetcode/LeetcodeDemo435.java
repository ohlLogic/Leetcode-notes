package com.Leetcode;

/**
 * Leetcode435，无重叠区间
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeetcodeDemo435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int m = intervals.length;
        int cnt = 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(intervals[0]);

        for (int i = 1; i < m; i++) {
            int[] pre = d.peekLast(), cur = intervals[i];
            int preleft = pre[0], preright = pre[1], curleft = cur[0], curright = cur[1];
            if (curleft >= preleft && curleft < preright) {
                cnt++;
                if(curright < preright)
                {
                    d.pollLast();
                    d.addLast(cur);
                }
            } else {
                d.addLast(cur);
            }
        }
        return cnt;
    }

    //动态规划
    public int eraseOverlapIntervals1(int[][] intervals)
    {
        int m = intervals.length;
        if(m == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for(int i = 1; i < m; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(intervals[j][1] <= intervals[i][0]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return m - Arrays.stream(dp).max().getAsInt();
    }

    //贪心
    public int eraseOverlapIntervals2(int[][] intervals)
    {
        int m = intervals.length;
        if(m == 0) return 0;

        //对区间的右端点进行排序
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int right = intervals[0][1], cnt = 1;
        for(int i = 1; i < m; i++)
        {
            if(intervals[i][0] >= right)
            {
                cnt++;
                right = intervals[i][1];
            }
        }
        return m - cnt;
    }
}
