package com.Leetcode;

/**
 * Leetcode1610,可见点的最大数目
 * 极角
 */

import java.util.*;
public class LeetcodeDemo1610 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location)
    {
        int x = location.get(0), y = location.get(1);
        //记录角度
        List<Double> list = new ArrayList<>();
        int cnt = 0;
        double pi = Math.PI, t = angle * pi / 180;
        for(List<Integer> point : points)
        {
            int a = point.get(0), b = point.get(1);
            //记录与location相同的点
            if(a == x && b == y && ++cnt >= 0) continue;
            //范围为[-180,180]
            list.add(Math.atan2(b - y, a - x));
        }

        Collections.sort(list);

        int n = list.size(), max = 0;
        //将坐标映射到[0,360]
        for(int i = 0; i < n; i++) list.add(list.get(i) + 2 * pi);
        for(int i = 0, j = 0; j < 2 * n; j++)
        {
            while(i < j && list.get(j) - list.get(i) > t) i++;
            max = Math.max(max, j - i + 1);
        }
        return cnt + max;
    }
}
