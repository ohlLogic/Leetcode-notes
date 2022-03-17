package com.Leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *Leetcode264,丑数2
 */
public class LeetcodeDemo264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
        System.out.println(nthUglyNumber1(10));
    }

    //动态规划
    public static int nthUglyNumber(int n)
    {
        int[] dp = new int[n + 1];

        //状态初始
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for(int i = 2; i <=n; i++)
        {
            int pp2 = dp[p2] * 2, pp3 = dp[p3] * 3, pp5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(pp2, pp3), pp5);
            if(dp[i] == pp2) p2++;
            if(dp[i] == pp3) p3++;
            if(dp[i] == pp5) p5++;
        }
        return dp[n];
    }

    /**
     * 优先队列：最小堆
     * 步骤：
     * 将最小的丑数1放入队列
     * 每次从队列取出最小值，将x对应的丑数2x,3x,5x入队
     * 循环多次，第n次出队就是第n个丑数
     */
    public static int nthUglyNumber1(int n)
    {
        int[] nums = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        Queue<Long> pq = new PriorityQueue<>();
        set.add(1L);
        pq.add(1L);
        for(int i = 1; i <= n; i++)
        {
            long x = pq.poll();
            if(i == n) return (int)x;
            for (int num : nums) {
                if(!set.contains(num * x))
                {
                    set.add(num * x);
                    pq.add(num * x);
                }
            }
        }
        return -1;
    }

}
