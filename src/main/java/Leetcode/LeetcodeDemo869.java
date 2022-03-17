package com.Leetcode;

/**
 * Leetcode869, 重新排序得到2的幂
 */

import java.util.*;

public class LeetcodeDemo869 {
    List<Integer> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    boolean[] flag;
    public static void main(String[] args) {
        LeetcodeDemo869 tt = new LeetcodeDemo869();
        System.out.println(tt.reorderedPowerOf2(18));
    }

    //TLE。。
    public boolean reorderedPowerOf2(int n)
    {
        List<Integer> list = new ArrayList<>();
        while(n != 0)
        {
            int r = n % 10;
            list.add(r);
            n /= 10;
        }
        flag = new boolean[list.size()];
        dfs(list, 0);
        for (Integer re : res) {
            System.out.println(re);
            int l = 0, r = 32;
            while(l < r)
            {
                int mid = l + r + 1 >> 1;
                if(Math.pow(2, mid) <= re) l = mid;
                else r = mid - 1;
            }
            if(Math.pow(2, r) == re) return true;
        }
        return false;
    }

    public void dfs(List<Integer> list, int u)
    {
        if(u == list.size())
        {
            if(sb.charAt(0) != '0') res.add(Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = 0; i < list.size(); i++)
        {
            if(flag[i]) continue;
            flag[i] = true;
            sb.append(list.get(i));
            dfs(list, u + 1);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }

    //打表+DFS
    static Set<Integer> set = new HashSet<>();
    static {
        for(int i = 1; i < (int) 1e9 + 10; i *= 2) set.add(i);
    }
    int m;
    int[] cnts = new int[10];
    public boolean reorderedPowerOf22(int n)
    {
        while(n != 0)
        {
            cnts[n % 10]++;
            n /= 10;
            m++;
        }
        return dfs1(0, 0);
    }

    public boolean dfs1(int u, int cur)
    {
        if(u == m) return set.contains(cur);
        for(int i = 0; i < 10; i++)
        {
            if(cnts[i] != 0)
            {
                cnts[i]--;
                //如果cur和i都等于0会让后面陷入死循环
                if((i != 0 || cur != 0) && dfs1(u + 1, cur * 10 + i)) return true;
                //回溯
                cnts[i]++;
            }
        }
        return false;
    }

    //打表+词频统计
    public boolean reorderedPowerOf23(int n) {
        int[] cnts = new int[10];
        while (n != 0) {
            cnts[n % 10]++;
            n /= 10;
        }
        int[] cur = new int[10];
        out:for (int x : set) {
            Arrays.fill(cur, 0);
            while (x != 0) {
                cur[x % 10]++;
                x /= 10;
            }
            for (int i = 0; i < 10; i++) {
                if (cur[i] != cnts[i]) continue out;
            }
            return true;
        }
        return false;
    }

}
