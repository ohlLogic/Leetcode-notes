package com.Leetcode;

/**
 * Leetcode786,第K个最小的素数分数
 */

import java.util.PriorityQueue;

public class LeetcodeDemo786 {
    //优先队列 + 扫描点对
    public int[] kthSmallsetPrimeFraction(int[] arr, int k)
    {
        int n = arr.length;
        //大根堆
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Double.compare(b[0] * 1.0 / b[1], a[0] * 1.0 / a[1]));
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                q.add(new int[]{arr[i], arr[j]});
                if(q.size() > k) q.poll();
            }
        }
        return q.poll();
    }

    //大根堆 + 多路归并
    public int[] kthSmallsetPrimeFraction1(int[] arr, int k)
    {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Double.compare(arr[a[0]] * 1.0 / arr[a[1]], arr[b[0]] * 1.0 / arr[b[1]]));

        for (int i = 1; i < n; i++) q.add(new int[]{0, i});
        while(k-- > 1)
        {
            int[] poll = q.poll();
            int i = poll[0], j = poll[1];
            if(i + 1 < j) q.add(new int[]{i + 1, j});
        }
        int[] poll = q.poll();
        return new int[]{arr[poll[0]], arr[poll[1]]};
    }

    double eps = 1e-8;
    int[] arr;
    int n, a, b;
    //二分 + 双指针
    public int[] kthSmallsetPrimeFraction2(int[] arr, int k)
    {
        this.arr = arr;
        n = arr.length;
        double l = 0, r = 1;
        while(r - l > eps)
        {
            double mid = (l + r) / 2;
            if(check(mid) >= k) r = mid;
            else l = mid;
        }
        return new int[]{a, b};
    }

    public int check(double x)
    {
        int ans = 0;
        for(int i = 0, j = 1; j < n; j++)
        {
            while(arr[i + 1] * 1.0 / arr[j] <= x) i++;
            if(arr[i] * 1.0 / arr[j] <= x) ans += i + 1;
            if(Math.abs(arr[i] * 1.0 / arr[j] - x) < eps)
            {
                a = arr[i]; b = arr[j];
            }
        }
        return ans;
    }
}
