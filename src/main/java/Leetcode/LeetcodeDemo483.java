package com.Leetcode;

/**
 * Leetcode483,最小好进制
 * 数学
 */
public class LeetcodeDemo483 {
    public String smallestGoodBase(String n)
    {
        long m = Long.parseLong(n);
        int max = (int) (Math.log(m) / Math.log(2) + 1);

        for(int len = max; len >= 3; len--)
        {
            long k = (long)Math.pow(m, 1.0 / (len - 1));
            long res = 0;
            for(int i = 0; i < len; i++) res = res * k + 1;
            if(res == m) return String.valueOf(k);
        }
        return String.valueOf(m - 1);
    }

    //二分
    public String smallestGoodBase1(String n)
    {
        long m = Long.parseLong(n);
        int max = (int) (Math.log(m) / Math.log(2) + 1);
        for(int len = max; len >= 3; len--)
        {
            long l = 2, r = m - 1;
            while(l < r)
            {
                long mid = l + r >> 1;
                if(check(mid, len, m) >= 0) r = mid;
                else l = mid + 1;
            }
            if(check(r, len, m) == 0) return String.valueOf(r);
        }
        return String.valueOf(m - 1);
    }

    public int check(long k, int len, long t)
    {
        long ans = 1;
        for(int i = 1; i < len; i++)
        {
            if(ans > (t - 1) / k) return 1;
            ans = ans * k + 1;
        }

        if(ans == t) return 0;
        return ans - t > 0 ? 1 : -1;
    }
}
