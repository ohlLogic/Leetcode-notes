package com.Leetcode;

/**
 * Leetcode495,提莫攻击
 */

public class LeetcodeDemo495 {
    public int findPoisonedDuration(int[] timeSeries, int duration)
    {
        int n = timeSeries.length;
        int res = 0, last = timeSeries[0] + duration - 1;
        for(int i = 1; i < n; i++)
        {
            if(last < timeSeries[i]) res += duration;
            else res += timeSeries[i] - timeSeries[i - 1];

            last = timeSeries[i] + duration - 1;
        }
        res += duration;
        return res;
    }


    public int findPoisonedDuration1(int[] timeSeries, int duration)
    {
        int res = 0, last = -1;
        for(int s : timeSeries)
        {
            int e = s + duration - 1;
            res += last < s ? duration : e - last;
            last = e;
        }
        return res;
    }
}
