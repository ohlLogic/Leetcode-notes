package com.Leetcode;

/**
 * Leetcode338,吧比特位计数
 */
public class LeetcodeDemo338 {
    public int[] countBits(int n)
    {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) ans[i] = check(i);
        return ans;
    }

    public int check(int x)
    {
        int cnt = 0;
        while(x != 0)
        {
            x &= (x - 1);
            cnt++;
        }
        return cnt;
    }

    /**
     * 动态规划
     * 二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
     * 偶数中 1 的个数一定和除以 2 之后的那个数一样多。
     * @param n
     * @return
     */
    public int[] countsBits1(int n)
    {
        int[] ans = new int[n + 1];
        for(int i = 0; i <= n; i++) ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}
