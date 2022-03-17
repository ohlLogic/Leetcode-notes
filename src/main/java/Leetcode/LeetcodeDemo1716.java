package com.Leetcode;

/**
 * Leetcode1716,计算力扣银行的钱
 * 模拟
 */
public class LeetcodeDemo1716 {
    public int totalMoney(int n)
    {
        int t = n / 7, m = n % 7, ans = 0;
        int i = 0;
        //整的周末
        for(; i < t; i++)
        {
            ans += (28 + 7 * i);
        }
        //余下
        if(m != 0)
        {
            ans += (1 + m) * m / 2;
            ans += i * m;
        }
        return ans;
    }

    public int totalMoney1(int n)
    {
        int a = n / 7, b = n % 7;
        int ans = 0, k = 1;
        while (a-- > 0) {
            ans += (k + (k + 6)) * 7 / 2;
            k++;
        }
        while (b-- > 0) ans += k++;
        return ans;

    }
}
