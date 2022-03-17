package com.Leetcode;

/**
 * Leetcode519,随机反转矩阵
 */

import java.util.*;

public class LeetcodeDemo519 {

    //双指针
    int m, n;
    Set<Integer> set = new HashSet<>();
    Random random = new Random(300);
    public LeetcodeDemo519(int m, int n)
    {
        this.m = m; this.n = n;
    }

    public int[] flip()
    {
        int a = random.nextInt(m * n), b = a;
        while(a >= 0 && set.contains(a)) a--;
        while(b < m * n && set.contains(b)) b++;
        int c = a >= 0 && !set.contains(a) ? a : b;
        set.add(c);
        return new int[]{c / n, c % n};
    }

    public void reset()
    {
        set.clear();
    }

    int cnt;
    Map<Integer, Integer> map = new HashMap<>();
//    public LeetcodeDemo295(int m, int n)
//    {
//        this m = m; this.n = n; this.cnt = m * n;
//    }
//
//    public int[] flip()
//    {
//        int x = random.nextInt(cnt--);
//        int idx = map.getOrDefault(x, x);
//        map.put(x, map.getOrDefault(cnt, cnt));
//        return new int[]{idx / n, idx % n};
//    }
//
//    public void reset()
//    {
//        cnt = m * n;
//        map.clear();
//    }

}
