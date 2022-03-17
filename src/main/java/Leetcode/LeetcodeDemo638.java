package com.Leetcode;

/**
 * Leetcode638,大礼包
 * dfs，完全背包
 */

import java.util.*;

public class LeetcodeDemo638 {
    public static void main(String[] args) {

    }

    int ans = 0x3f3f3f3f;
    int n, m;
    List<Integer> price, needs;
    Map<Integer, Integer> map = new HashMap<>();
    List<List<Integer>> special;
    //DFS
    public int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> _needs)
    {
        price = _price; special = _special; needs = _needs;

        //将price转为礼包格式，比如price[0]=100,转为礼包[1,0,0,...,0,100]
        n = price.size();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++) temp.add(0);
        for(int i = 0; i < n; i++)
        {
            List<Integer> clone = new ArrayList<>(temp);
            clone.set(i, 1);
            clone.add(price.get(i));
            special.add(clone);
        }

        //预处理每个礼包最多选多少个，利用哈希表进行存储
        m = price.size();
        for(int i = 0; i < m; i++)
        {
            List<Integer> x = special.get(i);
            int max = 0;
            for(int j = 0; j < n; j++)
            {
                int a = x.get(j), b = needs.get(j);
                if(a == 0 || b == 0) continue;
                max = Math.max(max, (int) Math.ceil(b / a));
            }
            map.put(i, max);
        }

        //dfs
        dfs(0, needs, 0);
        return ans;
    }

    void dfs(int u, List<Integer> list, int cur)
    {
        //ans记录最低价格，如果当前价格大于ans直接return
        if(cur >= ans) return;
        //当礼包special遍历时，更新ans
        if(u == m)
        {
            for(int i = 0; i < n; i++)
            {
                if(list.get(i) != 0) return;
            }
            ans = Math.min(ans, cur);
            return;
        }

        //dsf所有礼包
        List<Integer> x = special.get(u);
        out:for(int k = 0; k <= map.get(u); k++)
        {
            List<Integer> clist = new ArrayList<>(list);
            for(int i = 0; i < n; i++)
            {
                int a = x.get(i), b = clist.get(i);
                if(b < a * k) continue out;
                clist.set(i, b - a * k);
            }
            dfs(u + 1, clist, cur + k * x.get(n));
        }
    }

    //完全背包
    public int shoppingOffers1(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int[] g = new int[n + 1];
        g[0] = 1;
        for (int i = 1; i <= n; i++) {
            g[i] = g[i - 1] * (needs.get(i - 1) + 1);
        }
        int mask = g[n];
        int[] f = new int[mask];
        int[] cnt = new int[n];
        for (int state = 1; state < mask; state++) {
            f[state] = 0x3f3f3f3f;
            Arrays.fill(cnt, 0);
            for (int i = 0; i < n; i++) {
                cnt[i] = state % g[i + 1] / g[i];
            }
            for (int i = 0; i < n; i++) {
                if (cnt[i] > 0) f[state] = Math.min(f[state], f[state - g[i]] + price.get(i));
            }
            out:for (List<Integer> x : special) {
                int cur = state;
                for (int i = 0; i < n; i++) {
                    if (cnt[i] < x.get(i)) continue out;
                    cur -= x.get(i) * g[i];
                }
                f[state] = Math.min(f[state], f[cur] + x.get(n));
            }
        }
        return f[mask - 1];
    }

}
