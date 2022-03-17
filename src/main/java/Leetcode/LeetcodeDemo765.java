package com.Leetcode;

/**
 * Leetcode765,情侣牵手
 * 并查集，贪心
 */
public class LeetcodeDemo765 {
    int[] fa = new int[100];
    void union(int a, int b)
    {
        fa[find(a)] = fa[find(b)];
    }

    int find(int x)
    {
        //路径压缩
        if(fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
    public int minSwapsCouples(int[] row)
    {
        int n = row.length, m = n / 2;
        //并查集初始化
        for(int i = 0; i < m; i++) fa[i] = i;

        //合并
        for(int i = 0; i < n; i += 2) union(row[i] / 2, row[i + 1] / 2);

        int cnt = 0;
        for(int i = 0; i < m; i++)
        {
            if(i == find(i)) cnt++;
        }
        return m - cnt;
    }

    //贪心
    public int minSwapCouples1(int[] row)
    {
        int n = row.length;
        int res = 0;
        int[] cache = new int[n];
        //用来找到row数组某个值的下标
        for(int i = 0; i < n; i++) cache[row[i]] = i;
        for(int i = 0; i < n; i += 2)
        {
            int a = row[i], b = a ^ 1;
            if(row[i + 1] != b)
            {
                int src = i + 1, tar = cache[b];
                cache[row[tar]] = src;
                cache[row[src]] = tar;
                swap(row, src, tar);
                res++;
            }
        }
        return res;
    }
    void swap(int[] nums, int a, int b)
    {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
