package com.Leetcode;

/**
 * Leetcode365,水壶问题
 */

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class LeetcodeDemo265 {
    //BFS
    public boolean canMeasureWater(int x, int y, int z)
    {
        if(z < 0 || z > x + y) return false;

        Set<Integer> set = new HashSet<>();
        Queue<Integer> d = new ArrayDeque<>();
        d.offer(0);
        while(!d.isEmpty())
        {
            int n = d.poll();
            if(n + x <= x + y && set.add(n + x)) d.offer(n + x);
            if(n + y <= x + y && set.add(n + y)) d.offer(n + y);
            if(n - x >= 0 && set.add(n - x)) d.offer(n - x);
            if(n - y >= 0 && set.add(n - y)) d.offer(n - y);

            if(set.contains(z)) return true;
        }
        return false;
    }

    //GCD
    public boolean canMeasureWater1(int x, int y, int z)
    {
        if (z == 0) return true;
        if (x + y < z) return false;

        int big = Math.max(x, y);
        int small = x + y - big;

        if (small == 0) return big == z;


        while (big % small != 0) {
            int temp = small;
            small = big % small;
            big = temp;
        }
        return z % small == 0;
    }

}
