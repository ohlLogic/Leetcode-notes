package com.Leetcode;

/**
 * LeetcodeDemo629,K个逆序对数组
 * 动态规划
 */

import java.util.*;

public class LeetcodeDemo629 {
    public static void main(String[] args) {
        LeetcodeDemo629 tt = new LeetcodeDemo629();
        System.out.println(tt.kInversePairs(3, 1));
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    boolean[] flag;
    public int kInversePairs(int n, int k)
    {
        flag = new boolean[n + 1];
        dfs(n);
        int ans = 0;
        for (List<Integer> re : res) {
            if(check(re, k))
            {
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int n)
    {
        if(cur.size() == n)
        {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 1; i <= n; i++)
        {
            if(flag[i]) continue;
            flag[i] = true;
            cur.add(i);
            dfs(n);
            flag[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    public boolean check(List<Integer> cur, int k)
    {
        int cnt = 0, n = cur.size();
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();

        for(int i = 0; i < n; i++)
        {
            while(!d1.isEmpty() && d1.peekLast() > cur.get(i))
            {
                cnt++;
                d2.addLast(d1.pollLast());
            }

            d1.addLast(cur.get(i));
            while(!d2.isEmpty()) d1.addLast(d2.pollLast());
        }
        if(cnt == k) return true;
        return false;
    }

    //动态规划

    /**
     * dp[i][j]表示考虑数值[1,i],凑成逆序对数量为j的数组个数
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs1(int n, int k)
    {
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][k + 1];
        int[][] sum = new int[n + 1][k + 1];

        //初始化
        dp[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for(int i = 2; i <= n; i++)
        {
            for(int j = 0; j <= k; j++)
            {
                //对j和i大小进行分情况讨论，防止数值i位置靠前导致逆序对数量超过j
                dp[i][j] = j < i ? sum[i - 1][j] : (sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1] + mod) % mod;
                sum[i][j] = j == 0 ? dp[i][j] : (sum[i][j - 1] + dp[i][j]) % mod;
            }
        }
        return dp[n][k];

    }
}
