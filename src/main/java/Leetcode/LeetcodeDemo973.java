package com.Leetcode;

/**
 * Leetcode973,最接近原点的K个点
 * 快排，大根堆，排序
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetcodeDemo973 {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        LeetcodeDemo973 tt = new LeetcodeDemo973();
        System.out.println(tt.kClosest(points, 1));
    }

    //数组模拟
    public int[][] kClosest(int[][] points, int k)
    {
        int m = points.length;
        double[][] res = new double[m][2];

        for(int i = 0; i < m; i++)
        {
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            res[i][0] = i;
            res[i][1] = distance;
        }

        Arrays.sort(res, (a, b) -> {
            if(a[1] > b[1]) return 1;
            else if(a[1] < b[1]) return -1;
            else return 0;
        });

        int[][] ans = new int[k][];
        for(int i = 0; i < k; i++) ans[i] = points[(int) res[i][0]];
        return ans;
    }

    //大根堆
    public int[][] kClosest1(int[][] points, int k)
    {
        //大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int m = points.length;
        for(int i = 0; i < m; i++)
        {
            pq.add(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
            if(pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) ans[i] = points[pq.poll()[1]];
        return ans;
    }

    //快排思想
    public int[][] kClosest2(int[][] points, int k)
    {
        int m = points.length;
        int[][] res = new int[m][2];

        for(int i = 0; i < m; i++)
        {
            res[i][0] = i;
            res[i][1] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }

        int[][] topK = quickSelect(res, 0, m - 1, k - 1);

        //构造答案
        int[][] ans = new int[k][];
        for(int i = 0; i < k; i++) ans[i] = points[topK[i][0]];
        return ans;
    }


    public int[][] quickSelect(int[][] res, int l, int r, int k)
    {
        int j = Partition(res, l, r);
        if(j == k) return Arrays.copyOf(res, j + 1);
        return j < k ? quickSelect(res, j + 1, r, k) : quickSelect(res, l, j, k);
    }


    public int Partition(int[][] res, int l, int r)
    {
        int x = res[l + r >> 1][1], i = l - 1, j = r + 1;
        while(i < j)
        {
            do i++; while(res[i][1] < x);
            do j--; while(res[j][1] > x);
            if(i < j)
            {
                int[] temp = res[i];
                res[i] = res[j];
                res[j] = temp;
            }
        }
        return j;
    }
}
