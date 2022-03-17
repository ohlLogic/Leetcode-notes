package com.Leetcode;

/**
 * Leetcode1705,吃苹果的最大数目
 * 堆 + 贪心
 */

import java.util.PriorityQueue;

public class LeetcodeDemo1705 {

    public int eatenApples(int[] apples, int[] days)
    {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = apples.length, ans = 0, idx = 0;
        while(idx < n || !q.isEmpty())
        {
            if(idx < n && apples[idx] > 0) q.add(new int[]{idx + days[idx] - 1, apples[idx]});
            //清除当前最迟时间小于idx 的苹果
            while(!q.isEmpty() && q.peek()[0] < idx) q.poll();
            if(!q.isEmpty())
            {
                int[] cur = q.poll();
                if(--cur[1] > 0 && cur[0] > idx) q.add(cur);
                ans++;
            }
            idx++;
        }
        return ans;
    }

}
