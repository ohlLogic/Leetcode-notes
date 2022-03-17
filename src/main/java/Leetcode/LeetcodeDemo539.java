package com.Leetcode;

/**
 * Leetcode539,最小时间差
 */

import java.util.*;
public class LeetcodeDemo539 {
    public int findMinDifference(List<String> timePoints)
    {
        Collections.sort(timePoints);
        int n = timePoints.size();
        int ans = Integer.MAX_VALUE;

        //单独判断最后一个，和第一个
        String a = timePoints.get(0), b = timePoints.get(n - 1);
        if(getTime(b, a) >= 0) ans = Math.min(ans, getTime(b, a));

        for(int i = 1; i < n; i++)
        {
            ans = Math.min(ans, getTime(timePoints.get(i - 1), timePoints.get(i)));
        }
        return ans;
    }

    public int getTime(String a, String b)
    {
        String[] aa = a.split(":");
        String[] bb = b.split(":");

        int aleft = Integer.parseInt(aa[0]), aright = Integer.parseInt(aa[1]);
        int bleft = Integer.parseInt(bb[0]), bright = Integer.parseInt(bb[1]);
        int ans = 0;
        if(aleft < bleft)
        {
            ans += (60 * (bleft - (aleft + 1)) + (60 - aright) + bright);
        }
        if(aleft == bleft)
        {
            ans += (bright - aright);
        }
        if(aleft > bleft)
        {
            ans += (60 * (24 - (aleft + 1)) + (60 - aright) + 60 * bleft + bright);
        }
        return ans;
    }


    //转为分钟排序
    public int findMinDifference1(List<String> timePoints)
    {
        //一天1440分钟
        if(timePoints.size() > 1440) return 0;
        List<Integer> time = new ArrayList<>();
        for(String point : timePoints)
        {
            String[] split = point.split(":");
            time.add(Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]));
        }
        Collections.sort(time);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < time.size(); i++)
        {
            ans = Math.min(ans, time.get(i) - time.get(i - 1));
        }
        ans = Math.min(ans, 1440 + time.get(0) - time.get(time.size() - 1));
        return ans;
    }
}
