package com.Leetcode;

/**
 * Leetcode29,两数相除
 * 二分 + 快速乘法
 */
public class LeetcodeDemo29 {
    //不限制long
    public int divide(int divided, int divisor) {
        long res = 0;
        long x = divided, y = divisor;
        boolean neg = (x < 0 && y > 0) || (x > 0 && y < 0);
        if(x < 0) x = -x;
        if(y < 0) y = -y;

        long l = 0, r = x;
        while(l < r)
        {
            long mid = l + r + 1 >> 1;
            if(quickMulti(mid, y) <= x) l = mid;
            else r = mid - 1;
        }

        res = neg ? -l : l;
        if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

    public long quickMulti(long a, long b)
    {
        long res = 0;
        while(b > 0)
        {
            if((b & 1) == 1) res += a;
            b >>= 1;
            a += a;
        }
        return res;
    }

    //限制使用long
    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    public int divide1(int a, int b)
    {
        if (a == MIN && b == -1) return MAX;
        boolean flag = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) flag = true;

        //全部转为负数防止溢出
        if (a > 0) a = -a;
        if (b > 0) b = -b;

        int ans = 0;
        while(a <= b)
        {
            int tmp = b, cnt = 1;
            while(tmp >= a - tmp)
            {
                tmp += tmp;
                cnt += cnt;
            }
            a -= tmp;
            ans += cnt;
        }
        return flag ? -ans : ans;
    }
}
