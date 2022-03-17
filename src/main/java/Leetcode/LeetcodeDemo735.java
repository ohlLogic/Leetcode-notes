package com.Leetcode;

/**
 * Leetcode735,行星碰撞
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetcodeDemo735 {
    public int[] asteroidCollision(int[] asteroids)
    {
        Deque<Integer> d = new ArrayDeque<>();
        for(int asteroid : asteroids)
        {
            lp : {
                while(!d.isEmpty() && asteroid < 0 && 0 < d.peekLast())
                {
                    if(d.peekLast() < -asteroid)
                    {
                        d.pollLast();
                        continue;
                    }
                    else if(d.peekLast() == -asteroid) d.pollLast();
                    break lp;
                }
                d.addLast(asteroid);
            }
        }
        int m = d.size();
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) ans[i] = d.pollFirst();
        return ans;
    }
}
