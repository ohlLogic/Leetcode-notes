package com.Leetcode;

/**
 * Leetcode1725,可以形成最大正方形的矩形数目
 */

import java.util.HashMap;
import java.util.Map;

public class LeetcodeDemo1725 {
    public int countGoodRectangles(int[][] rectangles)
    {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < rectangles.length; i++)
        {
            int x = rectangles[i][0], y = rectangles[i][1];
            int cur = Math.min(x, y);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            max = Math.max(max, cur);
        }
        return map.get(max);
    }

    public int countGoodRectangles1(int[][] rectangles)
    {
        int max = 0, ans = 0;
        for (int[] r : rectangles) {
            int cur = Math.min(r[0], r[1]);
            if (cur == max) ans++;
            else if (cur > max) {
                max = cur; ans = 1;
            }
        }
        return ans;
    }
}
