package com.Leetcode;

/**
 * Leetcode56,合并区间
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeDemo56 {
    public int[][] merge(int[][] intervals)
    {
        int m = intervals.length;
        if(m == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //放入第一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for(int i = 1; i < m; i++)
        {
            int[] pre = res.get(res.size() - 1);
            int preright = pre[1], curleft = intervals[i][0], curright = intervals[i][1];
            if(preright < curleft) res.add(intervals[i]);
            else{
                pre[1] = Math.max(preright, curright);
                res.remove(res.size() - 1);
                res.add(pre);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge1(int[][] intervals)
    {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for(int[] tt : intervals)
        {
            if(idx == -1 || tt[0] > res[idx][1]) res[++idx] = tt;
            else res[idx][1] = Math.max(tt[1], res[idx][1]);
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
