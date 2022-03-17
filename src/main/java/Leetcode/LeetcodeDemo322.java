package com.Leetcode;

/**
 * Leetcode322,零钱兑换
 */

import java.util.Arrays;

public class LeetcodeDemo322 {
    public static void main(String[] args) {
        LeetcodeDemo322 test = new LeetcodeDemo322();
        int[] coins = {1, 2, 5};
        System.out.println(test.coinChange(coins, 11));
        System.out.println(test.coinChange1(coins, 11));
        System.out.println(test.coinChange2(coins, 11));
    }

    //递归，超时
    int res = Integer.MAX_VALUE;
    int[] temp;
    public  int coinChange(int[] coins, int amount)
    {
        int n = coins.length;
        if(n == 0) return -1;
        find(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public void find(int[] coins, int amount, int count)
    {
        if(amount < 0) return;
        if(amount == 0) res = Math.min(res, count);

        for (int coin : coins) {
            find(coins, amount - coin, count + 1);
        }
    }

    //递归 + 记忆化搜索
    public  int coinChange1(int[] coins, int amount)
    {
        int n = coins.length;
        if(n == 0) return -1;
        temp = new int[amount + 1];
        return find1(coins, amount);
    }
    public int find1(int[] coins, int amount)
    {
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(temp[amount] != 0) return temp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = find1(coins, amount - coin);
            if(res >= 0 && res < min) min = res + 1;
        }
        temp[amount] = (min == Integer.MAX_VALUE ? -1 : min);
        return temp[amount];
    }

    //动态规划
    public int coinChange2(int[] coins, int amount)
    {
        int max = 100000;
        int n = coins.length;
        if(n == 0) return -1;
        //dp[i]代表amount = i的最小花费硬币数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        //不用初始化，dp[0] = 0
        dp[0] = 0;

        //状态转移
        for(int i = 0; i < n; i++)
        {
            for(int j = coins[i]; j <= amount; j++)
            {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
