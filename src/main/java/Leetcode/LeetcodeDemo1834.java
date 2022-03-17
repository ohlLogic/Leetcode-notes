package com.Leetcode;

/**
 * Leetocde1834,单线程CPU
 * 模拟
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetcodeDemo1834 {
    public static void main(String[] args) {

    }

    public static int[] getOrder(int[][] tasks)
    {
        int n = tasks.length;
        int[] res = new int[n];

        //保留任务编号
        int[][] nts = new int[n][3];
        for(int i = 0; i < n; i++) nts[i] = new int[]{tasks[i][0], tasks[i][1], i};

        //根据任务时间进行排序
        Arrays.sort(nts, (a, b) -> a[0] - b[0]);

        //按照操作时间排序，再按照任务编号排序
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) ->{
            if(a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        for(int time = 1, j = 0, idx = 0; idx < n;)
        {
            //如果当前任务可以见天到队列中，入队时间<=time
            while(j < n && nts[j][0] <= time) q.add(nts[j++]);

            if(q.isEmpty()) time = nts[j][0];
            else{
                int[] cur = q.poll();
                res[idx++] = cur[2];
                time += cur[1];
            }
        }
        return res;
    }
}
