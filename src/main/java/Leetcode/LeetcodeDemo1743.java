package com.Leetcode;

/**
 * Leetocde1743,从 相邻元素对还原数组
 * 模拟
 */

import java.util.*;

public class LeetcodeDemo1743 {
    static int N = (int) 1e6+10;
    static int[] q = new int[N];
    public static void main(String[] args) {

    }

    //单向构造，哈希表计数
    public static int[] restoreArray(int[][] adjacentPairs)
    {
        int m = adjacentPairs.length, n = m + 1;
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] tt : adjacentPairs)
        {
            int a = tt[0], b = tt[1];
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
            cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            List<Integer> alist = map.getOrDefault(a, new ArrayList<>());
            alist.add(b);
            map.put(a, alist);
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            blist.add(a);
            map.put(b, blist);
        }

        int start = -1;
        for(int i : cnt.keySet())
        {
            if(cnt.get(i) == 1)
            {
                start = i;
                break;
            }
        }

        int[] ans = new int[n];
        ans[0] = start;
        ans[1] = map.get(start).get(0);
        for(int i = 2; i < n; i++)
        {
            int x = ans[i - 1];
            List<Integer> list = map.get(x);
            for(int j : list)
            {
                if(j != ans[i - 2]) ans[i] = j;
            }
        }
        return ans;
    }

    //双向构造
    public static int[] restoreArray1(int[][] adjacentPairs)
    {
        int m = adjacentPairs.length, n = m + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] tt : adjacentPairs)
        {
            int a = tt[0], b = tt[1];
            List<Integer> alist = map.getOrDefault(a, new ArrayList<>());
            alist.add(b);
            map.put(a, alist);
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            blist.add(a);
            map.put(b, blist);
        }

        int l = N / 2, r = l + 1;
        int std = adjacentPairs[0][0];
        List<Integer> list = map.get(std);
        q[l--] = std;
        q[r++] = list.get(0);
        //与std相邻的不止一个
        if(list.size() > 1) q[l--] = list.get(1);
        //目前[l,r]区间的个数
        while((r - 1) - (l + 1) + 1 < n)
        {
            List<Integer> alist = map.get(q[l + 1]);
            int j = l;
            for(int i : alist)
            {
                if(i != q[l + 2]) q[j--] = i;
            }
            l = j;

            List<Integer> blist = map.get(q[r - 1]);
            j = r;
            for(int i : blist)
            {
                if(i != q[r - 2]) q[j++] = i;
            }
            r = j;
        }

        //比ArrayscopyOfRangge更快
        int[] ans = new int[n];
        for (int i = l + 1, idx = 0; idx < n; i++, idx++) {
            ans[idx] = q[i];
        }
        return ans;

    }


}

