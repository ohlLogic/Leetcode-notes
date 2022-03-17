package com.Leetcode;

/**
 * Leetcode1518,换酒问题
 * 模拟
 */
public class LeetcodeDemo1518 {
    public int numWaterBottles(int numBottles, int numExchange)
    {
        int ans = numBottles, empty = numBottles;

        while(empty >= numExchange)
        {
            ans += empty / numExchange;
            empty = (empty / numExchange) + (empty % numExchange);
        }
        return ans;
    }

    public int numWaterBottles1(int n, int m)
    {
        int cnt = n / (m  - 1);
        return n % (m - 1) == 0 ? n + cnt - 1 : n + cnt;
    }
}
