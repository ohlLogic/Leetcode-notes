package com.Leetcode;

/**
 * Leetcode1337,矩阵中战斗力最弱的k行
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetcodeDemo1337 {
    public static void main(String[] args) {

    }

    //暴力
    public int[] kWeakestRows(int[][] mat, int k)
    {
        int m = mat.length, n = mat[0].length;
        int[][] tt = new int[m][2];
        for(int i = 0; i < m; i++)
        {
            int cur = 0;
            for(int j = 0; j < n; j++) cur += mat[i][j];
            tt[i] = new int[]{cur, i};
        }

        Arrays.sort(tt, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int[] res = new int[k];
        for(int i = 0; i < k; i++) res[i] = tt[i][1];
        return res;
    }

    //二分+堆
    public int[] kWeakestRows1(int[][] mat, int k)
    {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for(int i = 0; i < m; i++)
        {
            int l = 0, r = n - 1;
            while(l < r)
            {
                int mid = l + r + 1 >> 1;
                if(mat[i][mid] <= 1) l = mid;
                else l = mid - 1;
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            if(q.size() == k && q.peek()[0] > cur) q.poll();
            if(q.size() < k) q.add(new int[]{cur, i});
        }
        int[] res = new int[k];
        int idx = k - 1;
        while(!q.isEmpty()) res[idx--] = q.poll()[1];
        return res;
    }
}
