package com.Leetcode;

/**
 * Leetcode369,完全有效的平方数
 */
public class LeetcodeDemo367 {
    public boolean isPerfectSquare(int num)
    {
        return (int) Math.sqrt(num) * (int) Math.sqrt(num) == num;
    }

    //二分
    public boolean isPerfectSquare1(int num)
    {
        long l = 0, r = num;
        while(l < r)
        {
            long mid = l + r >> 1;
            if(mid * mid >= num) r = mid;
            else l = mid + 1;
        }
        return r * r == num;
    }

    //数学
    public boolean isPerfectSquare2(int num)
    {
        int x = 1;
        while(num > 0)
        {
            num -= x;
            x += 2;
        }
        return num == 0;
    }
}
